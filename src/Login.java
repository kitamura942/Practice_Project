import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Login extends HttpServlet {
  public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException{

    response.setContentType("text/html; charset=Shift_JIS");
    PrintWriter out = response.getWriter();

    // �t�H�[���ɓ��͂����p�����[�^�擾
    String user_name = request.getParameter("user_name");
    String pass = request.getParameter("pass");

    HttpSession session = request.getSession(true);

    boolean check = usercheck(user_name, pass);
    if (check){
      session.setAttribute("login", "OK");

      // �쐬��
      String target = (String)session.getAttribute("target");
      response.sendRedirect(target);
    }else{
      // �F�؂Ɏ��s������A���O�C����ʂɖ߂�
      session.setAttribute("status", "Not Auth");
      response.sendRedirect("/auth/Login");
    }
  }

  protected boolean usercheck(String user_name, String pass){
  	//�e�X�g�p�F���ƂŃf�[�^�x�[�X����F�؏������������Ă����悤�ɂ���
    if (user_id == "kitamura" && pass == "kitamura"){
      return true;
    }

    return false;
  }
}