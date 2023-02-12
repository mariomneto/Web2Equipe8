/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import classes.Pedido;
import static classes.Pedido.Status.*;
import classes.Produto;
import facades.FuncionarioFacade;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author T-GAMER
 */
@WebServlet(name = "FuncionariosServlet", urlPatterns = {"/FuncionariosServlet"})
public class FuncionariosServlet extends HttpServlet {

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
            HttpSession session = request.getSession();
                if (session.getAttribute("login") == null) {
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.html");
                request.setAttribute("msg", "Usuário necessita estar logado no Sistema");
                dispatcher.forward(request,response);
                }else{
                   String action = request.getParameter("action");
                    if (action.equals ("listarPedidosAbertos") || action == null){
                      try{
                            List<Pedido> pedidos= new ArrayList<>();
                            String status= "EM_ABERTO";
                            FuncionarioFacade funcionariofacade= new FuncionarioFacade();
                            pedidos = funcionariofacade.listarPedidoStatus(status);
                            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/inicialFuncionarios.jsp");
                            request.setAttribute("pedidosAbertos", pedidos);
                            dispatcher.forward(request,response);
                        } catch (Exception e) {
                            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/paginaDeErro.jsp");
                            request.setAttribute("msg", "Não foi possível listar os pedidos abertos.");
                            dispatcher.forward(request,response);
                            e.printStackTrace();
                        }
                        
                    }
                    else if(action.equals("confirmarRecolhimento")){
                       try{
                            String idm = request.getParameter("id");
                            int id = Integer.parseInt(idm);
                            FuncionarioFacade funcionariofacade = new FuncionarioFacade();
                            Pedido pedido = new Pedido();
                            List<Pedido> pedidos= new ArrayList<>();
                            pedido = funcionariofacade.buscarPedido(id);
                            pedido.setStatus(RECOLHIDO);
                            String status= "EM_ABERTO";
                            pedidos = funcionariofacade.listarPedidoStatus(status);
                            funcionariofacade.atualizarPedido(pedido);    
                            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/inicialFuncionarios.jsp");
                            request.setAttribute("msg", "Pedido de Número: " + id + " foi Recolhido");
                            request.setAttribute("pedidosAbertos", pedidos);
                            dispatcher.forward(request,response);
                             } catch (NumberFormatException e) {
                                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/paginaDeErro.jsp");
                                    request.setAttribute("msg", "Ocorreu um erro ao recuperar o número do pedido. Verifique se o valor é um número inteiro válido.");
                                    dispatcher.forward(request,response);
                             } catch (Exception e) {
                                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/paginaDeErro.jsp");
                                    request.setAttribute("msg", "Ocorreu um erro inesperado ao tentar recuperar ou atualizar o pedido.");
                                    dispatcher.forward(request,response);
                             }  
                    }
                    else if (action.equals("listarPedidos")){
                        try{
                             List<Pedido> pedidos= new ArrayList<>();
                             FuncionarioFacade funcionariofacade= new FuncionarioFacade();
                             pedidos = funcionariofacade.listarPedidos();
                             RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/visualizacaoDePedidos.jsp");
                             request.setAttribute("listaPedidos", pedidos);
                             dispatcher.forward(request,response);
                            }catch (Exception e) {
                                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/paginaDeErro.jsp");
                                request.setAttribute("msg", "Ocorreu um erro ao listar os pedidos: " + e.getMessage());
                                dispatcher.forward(request,response);
                            }    
                    }
                    else if (action.equals("confirmarLavagem")){
                        try{
                            String idm = request.getParameter("id");
                            int id = Integer.parseInt(idm);
                            FuncionarioFacade funcionariofacade = new FuncionarioFacade();
                            Pedido pedido = new Pedido();
                            List<Pedido> pedidos= new ArrayList<>();
                            pedido = funcionariofacade.buscarPedido(id);
                            pedido.setStatus(AGUARDANDO_PAGAMENTO);
                            funcionariofacade.atualizarPedido(pedido);    
                            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/visualizacaoDePedidos.jsp");
                            pedidos = funcionariofacade.listarPedidos();
                            request.setAttribute("listaPedidos", pedidos);
                            request.setAttribute("msg", "Pedido de Número: " + id + " está aguardando pagamento!");
                            dispatcher.forward(request,response);
                         } catch (NumberFormatException e) {
                                // Tratar a exceção de conversão de string para int
                                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/paginaDeErro.jsp");
                                request.setAttribute("erro", "Erro ao converter o ID do pedido para inteiro");
                                dispatcher.forward(request, response);
                         } catch (Exception e) {
                                // Tratar qualquer outra exceção que possa ocorrer
                                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/paginaDeErro.jsp");
                                request.setAttribute("erro", "Ocorreu um erro ao alterar o status do pedido");
                                dispatcher.forward(request, response);
                         }
                    }
                    else if (action.equals("finalizarPedido")){
                       try{
                            String idm = request.getParameter("id");
                            int id = Integer.parseInt(idm);
                            FuncionarioFacade funcionariofacade = new FuncionarioFacade();
                            Pedido pedido = new Pedido();
                            List<Pedido> pedidos= new ArrayList<>();
                            pedido = funcionariofacade.buscarPedido(id);
                            pedido.setStatus(FINALIZADO);
                            funcionariofacade.atualizarPedido(pedido);
                            pedidos = funcionariofacade.listarPedidos();
                            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/visualizacaoDePedidos.jsp");
                            request.setAttribute("listaPedidos", pedidos);
                            request.setAttribute("msg", "Pedido de Número: " + id + " foi finalizado!");
                            dispatcher.forward(request,response); 
                        } catch (NumberFormatException ex) {
                            ex.printStackTrace();
                            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/erro.jsp");
                            request.setAttribute("mensagem", "ID do pedido inválido!");
                            dispatcher.forward(request, response);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/erro.jsp");
                            request.setAttribute("mensagem", "Erro ao finalizar o pedido!");
                            dispatcher.forward(request, response);
                        }
                    }
                    else if (action.equals("listarProdutos")){
                      try{
                        FuncionarioFacade funcionariofacade = new FuncionarioFacade();
                        List<Produto> produtos = new ArrayList<>();
                        produtos=funcionariofacade.listarProdutos();
                        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ManutencaoPecasdeRoupa.jsp");
                        request.setAttribute("listaProdutos", produtos);
                        dispatcher.forward(request,response);    
                        } catch (Exception e) {
                             RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/paginaDeErro.jsp");
                             request.setAttribute("msg", "Não foi possível listar os produtos: " + e.getMessage());
                             dispatcher.forward(request, response);
                        }
                    }
                    else if (action.equals("inserirProduto")){
                        FuncionarioFacade funcionariofacade = new FuncionarioFacade();
                        Produto produto = new Produto();
                        List<Produto> produtos = new ArrayList<>();
                        String nome = request.getParameter("nome");
                        String data = request.getParameter("prazolavagem");
                        String val= request.getParameter("valorunitario");
                        try{
                        double valor = Double.parseDouble(val);
                        Date date1 = new SimpleDateFormat("yyyy-mm-dd").parse(data);
                        produto.setNome(nome);
                        produto.setPrazo(date1);
                        produto.setValor(valor);
                        funcionariofacade.adicionarProduto(produto);
                        produtos=funcionariofacade.listarProdutos();
                        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ManuntencaoPecasdeRoupa.jsp");
                        request.setAttribute("msg", "Produto inserido com sucesso!");
                        request.setAttribute("listaProdutos", produtos);
                        dispatcher.forward(request,response); 
                        } catch (NumberFormatException e) {
                            request.setAttribute("mensagemErro", "O valor informado é inválido");
                            request.getRequestDispatcher("/paginaDeErro.jsp").forward(request, response);
                        } catch (ParseException e) {
                            request.setAttribute("mensagemErro", "A data informada é inválida");
                            request.getRequestDispatcher("/paginaDeErro.jsp").forward(request, response);
                        } catch (Exception e) {
                            request.setAttribute("mensagemErro", "Ocorreu um erro inesperado");
                            request.getRequestDispatcher("/paginaDeErro.jsp").forward(request, response);
                        }  
                    }
                    else if(action.equals("atualizarProdutoForm")){
                        String idm = request.getParameter("id");
                        int id = Integer.parseInt(idm);
                        FuncionarioFacade funcionariofacade = new FuncionarioFacade();
                        Produto produto = new Produto();
                        produto=funcionariofacade.buscarProduto(id);
                        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/EditarPecasRoupa.jsp");
                        request.setAttribute("attproduto", produto);
                        dispatcher.forward(request, response);
                    }
                    else if(action.equals("atualizarProduto")){
                       try{
                                String idm = request.getParameter("id");
                                int id = Integer.parseInt(idm);
                                List<Produto> produtos = new ArrayList<>();
                                String nome = request.getParameter("nome");
                                String data = request.getParameter("prazolavagem");
                                String val= request.getParameter("valorunitario");
                                FuncionarioFacade funcionariofacade = new FuncionarioFacade();
                                Produto produto = new Produto();
                                produto=funcionariofacade.buscarProduto(id);
                                double valor = Double.parseDouble(val);
                                Date date1 = new SimpleDateFormat("yyyy-mm-dd").parse(data);
                                produto.setNome(nome);
                                produto.setPrazo(date1);
                                produto.setValor(valor);
                                funcionariofacade.atualizarProduto(produto);
                                produtos=funcionariofacade.listarProdutos();
                                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ManuntencaoPecasdeRoupa.jsp");
                                request.setAttribute("msg", "Produto inserido com sucesso!");
                                request.setAttribute("listaProdutos", produtos);
                                dispatcher.forward(request,response); 
                            } catch (NumberFormatException e) {
                                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/paginaDeErro.jsp");
                                request.setAttribute("msg", "Erro ao inserir produto: ID inválido.");
                                dispatcher.forward(request,response);
                            } catch (ParseException e) {
                                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/paginaDeErro.jsp");
                                request.setAttribute("msg", "Erro ao inserir produto: Formato de data inválido.");
                                dispatcher.forward(request,response);
                            } catch (Exception e) {
                                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/paginaDeErro.jsp");
                                request.setAttribute("msg", "Erro ao inserir produto: " + e.getMessage());
                                dispatcher.forward(request,response);
                            }
                        
                    }
                    else if(action.equals("removerProduto")){
                        try{
                                String idm = request.getParameter("id");
                                int id = Integer.parseInt(idm);
                                List<Produto> produtos = new ArrayList<>();
                                Produto produto = new Produto();
                                FuncionarioFacade funcionariofacade = new FuncionarioFacade();
                                funcionariofacade.removerProduto(id);
                                produtos= funcionariofacade.listarProdutos();
                                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ManuntencaoPecasdeRoupa.jsp");
                                request.setAttribute("msg", "Produto removido com sucesso!");
                                request.setAttribute("listaProdutos", produtos);
                        } catch (NumberFormatException e) {
                            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/paginaDeErro.jsp");
                            request.setAttribute("msg", "Id inválido. Por favor, insira um número inteiro válido.");
                            dispatcher.forward(request, response);
                        } catch (Exception e) {
                            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/paginaDeErro.jsp");
                            request.setAttribute("msg", "Ocorreu um erro ao remover o produto. Por favor, tente novamente mais tarde.");
                            dispatcher.forward(request, response);
                        }
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
