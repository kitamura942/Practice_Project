import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Login extends HttpServlet {
  public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException{

    response.setContentType("text/html; charset=Shift_JIS");
    PrintWriter out = response.getWriter();

    // フォームに入力したパラメータ取得
    String user_name = request.getParameter("user_name");
    String pass = request.getParameter("pass");

    HttpSession session = request.getSession(true);

    boolean check = usercheck(user_name, pass);
    if (check){
      session.setAttribute("login", "OK");

      // 作成中
      String target = (String)session.getAttribute("target");
      response.sendRedirect(target);
    }else{
      // 認証に失敗したら、ログイン画面に戻す
      session.setAttribute("status", "Not Auth");
      response.sendRedirect("/auth/Login");
    }
  }

  protected boolean usercheck(String user_name, String pass){
  	//テスト用：あとでデータベースから認証情報を引っ張ってこれるようにする
    if (user_id == "kitamura" && pass == "kitamura"){
      return true;
    }

    return false;
  }
}