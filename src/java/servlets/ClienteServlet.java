/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import classes.Cliente;
import classes.Pedido;
import static classes.Pedido.Status.CANCELADO;
import static classes.Pedido.Status.EM_ABERTO;
import static classes.Pedido.Status.PAGO;
import static classes.Pedido.Status.REJEITADO;
import classes.PedidoProduto;
import classes.Produto;
import facades.ClienteFacade;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

/**
 *
 * @author T-GAMER
 */
@WebServlet(name = "ClienteServlet", urlPatterns = {"/ClienteServlet"})
public class ClienteServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();
            if (session.getAttribute("login") == null) {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.html");
            request.setAttribute("msg", "Usuário necessita estar logado no Sistema");
            dispatcher.forward(request,response);
            }
            else{
             String action = request.getParameter("action");
             if (action.equals ("listarPedidosCliente") || action == null){
                int id = (int) session.getAttribute("idLogado");
                ClienteFacade clientefacade = new ClienteFacade();
                Cliente cliente = new Cliente();
                cliente = clientefacade.buscarCliente(id);
                    if(cliente != null){
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/listagemPedidoTabela.jsp");
                    request.setAttribute("pedidosCliente", cliente);
                    dispatcher.forward(request,response);
                    }else{
                      RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/pedidoListar.jsp");
                      request.setAttribute("msg", "Pedidos do cliente não encontrados.");
                      dispatcher.forward(request,response);  
                }
             }
             else if(action.equals ("pedidoForm")){
                ClienteFacade clientefacade = new ClienteFacade();
                List <Produto> produtos= new ArrayList<>();
                produtos = clientefacade.listarProdutos();
                 if(produtos != null){
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Pedido.jsp");
                    request.setAttribute("produtos", produtos);
                    dispatcher.forward(request,response);
                    }else{
                      RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
                      request.setAttribute("msg", "Os dados não foram encontrados.");
                      dispatcher.forward(request,response);
                    }  
                 
             }
             else if (action.equals ("verificarOrcamento")){ 
                 String [] prod = request.getParameterValues("produtoselecionados");
                  int[] produtos = Stream.of(prod)
                        .mapToInt(Integer::parseInt)
                        .toArray();
                 String [] quant= request.getParameterValues("quantidadeselecionadas");
                  int[] quantidade = Stream.of(quant)
                        .mapToInt(Integer::parseInt)
                        .toArray();
                 ClienteFacade clientefacade = new ClienteFacade();
                 Produto produto = new Produto();
                 PedidoProduto pedidoproduto = new PedidoProduto();
                 Pedido pedido= new Pedido();
                 List<PedidoProduto> listaProdutos= new ArrayList<>();
                   for (int i = 0; i <= produtos.length; i++ ){
                       produto = clientefacade.buscarProduto(produtos[i]);
                       pedidoproduto.setProduto(produto);
                       pedidoproduto.setQuantidade(quantidade[i]);
                       listaProdutos.add(pedidoproduto); 
                   }
                   pedido.setPedidoProduto(listaProdutos);
                   pedido.setPrazo(new Date());
                   pedido.setOrcamento(pedido.calculaOrcamento());
                   RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Pedido.jsp");
                   request.setAttribute("orcamento", pedido);
                   dispatcher.forward(request,response);    
             }
             else if(action.equals ("adicionarPedido")){
                 int id = (int) session.getAttribute("idLogado");
                 String [] prod = request.getParameterValues("produtoselecionados");
                  int[] produtos = Stream.of(prod)
                        .mapToInt(Integer::parseInt)
                        .toArray();
                 String [] quant= request.getParameterValues("quantidadeselecionadas");
                  int[] quantidade = Stream.of(quant)
                        .mapToInt(Integer::parseInt)
                        .toArray();
                 ClienteFacade clientefacade = new ClienteFacade();
                 Cliente cliente = new Cliente();
                 Produto produto = new Produto();
                 PedidoProduto pedidoproduto = new PedidoProduto();
                 Pedido pedido= new Pedido();
                 List<PedidoProduto> listaProdutos= new ArrayList<>();
                   for (int i = 0; i <= produtos.length; i++ ){
                       produto = clientefacade.buscarProduto(produtos[i]);
                       pedidoproduto.setProduto(produto);
                       pedidoproduto.setQuantidade(quantidade[i]);
                       listaProdutos.add(pedidoproduto); 
                   }
                   pedido.setPedidoProduto(listaProdutos);
                   pedido.setPrazo(new Date());
                   pedido.setOrcamento(pedido.calculaOrcamento());
                   pedido.setStatus(EM_ABERTO);
                   int idPedido = clientefacade.adicionarPedido(pedido);
                   cliente = clientefacade.buscarCliente(id);
                   List<Pedido> pedidos= new ArrayList<>();
                   pedidos.add(pedido);
                   cliente.setPedidos(pedidos);
                   clientefacade.atualizarCliente(cliente);
                   RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Cliente/inicialCliente.jsp");
                   request.setAttribute("msg", "Pedido efetuado com sucesso!" + idPedido);
                   dispatcher.forward(request,response);       
             }
             else if(action.equals ("rejeitarOrcamento")){
                 int id = (int) session.getAttribute("idLogado");
                 String [] prod = request.getParameterValues("produtoselecionados");
                  int[] produtos = Stream.of(prod)
                        .mapToInt(Integer::parseInt)
                        .toArray();
                 String [] quant= request.getParameterValues("quantidadeselecionadas");
                  int[] quantidade = Stream.of(quant)
                        .mapToInt(Integer::parseInt)
                        .toArray();
                 ClienteFacade clientefacade = new ClienteFacade();
                 Cliente cliente = new Cliente();
                 Produto produto = new Produto();
                 PedidoProduto pedidoproduto = new PedidoProduto();
                 Pedido pedido= new Pedido();
                 List<PedidoProduto> listaProdutos= new ArrayList<>();
                   for (int i = 0; i <= produtos.length; i++ ){
                       produto = clientefacade.buscarProduto(produtos[i]);
                       pedidoproduto.setProduto(produto);
                       pedidoproduto.setQuantidade(quantidade[i]);
                       listaProdutos.add(pedidoproduto); 
                   }
                   pedido.setPedidoProduto(listaProdutos);
                   pedido.setPrazo(new Date());
                   pedido.setOrcamento(pedido.calculaOrcamento());
                   pedido.setStatus(REJEITADO);
                   int idPedido = clientefacade.adicionarPedido(pedido);
                   cliente = clientefacade.buscarCliente(id);
                   List<Pedido> pedidos= new ArrayList<>();
                   pedidos.add(pedido);
                   cliente.setPedidos(pedidos);
                   clientefacade.atualizarCliente(cliente);
                   RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Cliente/inicialCliente.jsp");
                   request.setAttribute("msg", "Pedido Rejeitado!");
                   dispatcher.forward(request,response);       
             }
             else if(action.equals ("consultarPedido")){
                    String idm = request.getParameter("id");
                    int id = Integer.parseInt(idm);
                    ClienteFacade clientefacade = new ClienteFacade();
                    Pedido pedido = new Pedido();
                    pedido = clientefacade.buscarPedido(id);
                        if (pedido != null){
                        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ConsultaPedido.jsp");
                        request.setAttribute("consultaPedido", pedido);
                        dispatcher.forward(request,response);
                        }else{
                            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ConsultaPedido.jsp");
                            request.setAttribute("msg", "Pedido não encontrado");
                            dispatcher.forward(request,response);
                        }  
             }
             else if (action.equals("cancelarPedido")){
                    String idm = request.getParameter("id");
                    int id = Integer.parseInt(idm);
                    ClienteFacade clientefacade = new ClienteFacade();
                    Pedido pedido = new Pedido();
                    pedido = clientefacade.buscarPedido(id);
                    pedido.setStatus(CANCELADO);
                        if (pedido != null){
                        clientefacade.atualizarPedido(pedido);    
                        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ConsultaPedido.jsp");
                        request.setAttribute("msg", "Pedido de Número: " + id + " foi cancelado!");
                        dispatcher.forward(request,response);
                        }else{
                            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ConsultaPedido.jsp");
                            request.setAttribute("msg", "Erro ao cancelar o Pedido!");
                            dispatcher.forward(request,response);
                        }   
             }
             else if(action.equals ("pagarForm")){
                 String idm = request.getParameter("id");
                 int id = Integer.parseInt(idm);
                 ClienteFacade clientefacade = new ClienteFacade();
                 Pedido pedido = new Pedido();
                 pedido = clientefacade.buscarPedido(id);
                 RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/PagamentoPedido.jsp");
                 request.setAttribute("pedido", pedido);
                 dispatcher.forward(request,response);
             }
             else if(action.equals ("pagarPedido")){
                 String idm = request.getParameter("id");
                 int id = Integer.parseInt(idm);
                /* String titular = request.getParameter("titular");
                 int cvc = Integer.parseInt(request.getParameter("cvc"));
                 int numcard = Integer.parseInt(request.getParameter("numcard"));
                 String ano = request.getParameter("ano");
                 String mes = request.getParameter("mes");
                 Date dat = new Date();
                 PagamentoCartao pag = new PagamentoCartao();
                 pag.setData(dat);
                 pag.setCvc(cvc);
                 pag.setNumerocartao(numcard);
                 pag.setTitular(titular);
                 String date = "/"+ano;
                 String datef = mes+date;
                 pag.setValidadeCartao(datef);*/
                 ClienteFacade clientefacade = new ClienteFacade();
                 Pedido pedido = new Pedido();
                 pedido = clientefacade.buscarPedido(id);
               /*double orc = pedido.getOrcamento();
                 pag.setValor(orc);
                 pedido.setPagamento(pag);
                  if (pedido.getPagamento() != null){
                      pedido.setStatus(PAGO);
                      x = 1;
                 }
                  if(x == 1){
                        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ConsultaPedido.jsp");
                        request.setAttribute("msgPagS", "Pagamento Efetuado com Sucesso!");
                        request.setAttribute("pagamento", pag);
                        dispatcher.forward(request,response);
                    }
                  else{
                        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ConsultaPedido.jsp");
                        request.setAttribute("msgPage", "Não foi possivel efetuar o pagamento!");
                        dispatcher.forward(request,response);
                  }*/
                 pedido.setStatus(PAGO);
                 clientefacade.atualizarPedido(pedido);
                 RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ConsultaPedido.jsp");
                 request.setAttribute("msgPagS", "Pagamento Efetuado com Sucesso!");
                 dispatcher.forward(request,response);
             }
           }
             
        }
    }
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
