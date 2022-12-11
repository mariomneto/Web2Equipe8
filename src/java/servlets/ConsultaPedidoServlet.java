/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import classes.Pedido;
import static classes.Pedido.Status.AGUARDANDO_PAGAMENTO;
import static classes.Pedido.Status.PAGO;
import classes.PedidoProduto;
import classes.Produto;
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

/**
 *
 * @author T-GAMER
 */
@WebServlet(name = "ConsultaPedidoServlet", urlPatterns = {"/ConsultaPedidoServlet"})
public class ConsultaPedidoServlet extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
        HttpSession sess = request.getSession(); 
        if(sess.getAttribute("listareal") == null){    
       Date myDate= new Date();
        List<Produto> produtos = new ArrayList<>();
        List<PedidoProduto> pedidoprodutoslist = new ArrayList<>();
        List<PedidoProduto> pedidoprodutoslist2 = new ArrayList<>();
        Produto produto1 = new Produto();
        produto1.setNumProduto(1);
        produto1.setNome("Edredom");
        produto1.setValor(100.0);
        produto1.setPrazo(myDate);
        Produto produto2 = new Produto();
        produto2.setNumProduto(2);
        produto2.setNome("Cobertor");
        produto2.setValor(40.0);
        produto2.setPrazo(myDate);
        PedidoProduto pedidoproduto1= new PedidoProduto();
        PedidoProduto pedidoproduto2= new PedidoProduto();
        PedidoProduto pedidoproduto3= new PedidoProduto();
        pedidoproduto1.setProduto(produto1);
        pedidoproduto2.setProduto(produto2);
        pedidoproduto1.setQuantidade(1);
        pedidoproduto2.setQuantidade(2);
        pedidoproduto3.setProduto(produto2);
        pedidoproduto3.setQuantidade(3);
        pedidoprodutoslist.add(pedidoproduto1);
        pedidoprodutoslist.add(pedidoproduto2);
        pedidoprodutoslist2.add(pedidoproduto3);
        Pedido pedido1 = new Pedido();
        pedido1.setNumPedido(1);
        pedido1.setPrazo(myDate);
        pedido1.setStatus(AGUARDANDO_PAGAMENTO);
        pedido1.setPedidoProduto(pedidoprodutoslist);
        pedido1.setOrcamento(pedido1.calculaOrcamento());
        Pedido pedido2 = new Pedido();
        pedido2.setNumPedido(2);
        pedido2.setPrazo(myDate);
        pedido2.setStatus(PAGO); 
        pedido2.setPedidoProduto(pedidoprodutoslist2);
        pedido2.setOrcamento(pedido2.calculaOrcamento());
        ArrayList<Pedido> Pedidos = new ArrayList<Pedido>();
        Pedidos.add(pedido1);
        Pedidos.add(pedido2);
       /* Pedido pedido1 = new Pedido();
        pedido1.setNumPedido(1);
        pedido1.setPrazo(myDate);
        pedido1.setOrcamento(140.00);
        pedido1.setStatus(AGUARDANDO_PAGAMENTO);
        pedido1.setProduto(produtos);
        Pedido pedido2 = new Pedido();
        pedido2.setNumPedido(2);
        pedido2.setPrazo(myDate);
        pedido2.setOrcamento(200.00);
        pedido2.setStatus(PAGO); 
        pedido2.setProduto(produtos);
        ArrayList<Pedido> Pedidos = new ArrayList<Pedido>();
        Pedidos.add(pedido1);
        Pedidos.add(pedido2);*/
        int x = 0;
        ArrayList<Pedido> filtroList = new ArrayList<Pedido>();
        String pedi = request.getParameter("pesquisapedido"); 
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head> Socorro");
        int nump = Integer.parseInt(pedi);
         for (Pedido pedido : Pedidos){
            if (pedido.getNumPedido()== nump) {
                filtroList.add(pedido);
                 x = 1;
            }}
        if (x == 1){
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ConsultaPedido.jsp");
            request.setAttribute("lista", filtroList);
            sess.setAttribute("list", filtroList);
            sess.setAttribute("listareal", Pedidos);
            dispatcher.forward(request,response);
        }else{
         RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ConsultaPedido.jsp");
         request.setAttribute("msg", "Pedido não encontrado");
         dispatcher.forward(request,response);
        }
         out.println("</head>");
         out.println("</body>");
         out.println("</html>");
         

        }else{
        ArrayList<Pedido> Pedidos = (ArrayList<Pedido>) sess.getAttribute("listareal");
        int x = 0;
        ArrayList<Pedido> filtroList = new ArrayList<Pedido>();
        String pedi = request.getParameter("pesquisapedido"); 
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        int nump = Integer.parseInt(pedi);
        for (Pedido pedido : Pedidos){
            if (pedido.getNumPedido()== nump) {
                filtroList.add(pedido);
                 x = 1;
            }}
        if (x == 1){
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ConsultaPedido.jsp");
            request.setAttribute("lista", filtroList);
            sess.setAttribute("list", filtroList);
            sess.setAttribute("listareal", Pedidos);
             dispatcher.forward(request,response);
        }else{
         RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ConsultaPedido.jsp");
         request.setAttribute("msg", "Pedido não encontrado!");
         dispatcher.forward(request,response);
        }
         out.println("</head>");
         out.println("</body>");
         out.println("</html>");
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
