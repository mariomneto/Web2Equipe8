/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;
import classes.PagamentoCartao;
import classes.Pedido;
import classes.Pedido.Status;
import static classes.Pedido.Status.PAGO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author T-GAMER
 */
@WebServlet(name = "PagamentoPedidoServlet", urlPatterns = {"/PagamentoPedidoServlet"})
public class PagamentoPedidoServlet extends HttpServlet {

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
                int x=0;
                String titular = request.getParameter("titular");
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
               // DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MMM-uuuu");
               // YearMonth yearMonth = YearMonth.parse(date, dateFormat);
                pag.setValidadeCartao(datef);
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                HttpSession sess = request.getSession(false);
                ArrayList<Pedido> list = (ArrayList<Pedido>) sess.getAttribute("list");
                   for (Pedido pedido: list){
                             double orc = pedido.getOrcamento();
                             pag.setValor(orc);
                             pedido.setPagamento(pag);
                              if (pedido.getPagamento() != null){
                               pedido.setStatus(PAGO);
                                 x = 1;}}
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
                      
         out.println("</head>");
         out.println("</body>");
         out.println("</html>");
        }
        
        
    }}

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
