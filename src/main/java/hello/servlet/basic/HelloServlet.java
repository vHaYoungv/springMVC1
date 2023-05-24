package hello.servlet.basic;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "helloServlet", urlPatterns ="/hello") // /hello로 오면 이 서블릿이 실행되는 것
public class HelloServlet extends HttpServlet { //extends HttpServlet!

    @Override //ctrl + O로 override할 메소드 찾아오기
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("HelloServlet.service");
        System.out.println("request = " + request);
        System.out.println("response = " + response);

        String username = request.getParameter("username"); //reqest.getParameter로 url에 입력하는 /hello?username="kim" 같은 값을 얻어낼 수 있다.
        System.out.println("username = " + username);

        response.setContentType("text/plain"); //이 둘은 ContentType 에 들어간다(헤더 정보)
        response.setCharacterEncoding("utf-8"); //이 둘은 ContentType 에 들어간다  //문자 세트, 즉 인코딩 정보를 알려주어야 함
        response.getWriter().write("hello " + username); //getWriter().write: 얘는 body에 나타남
    }
}
