package acc.br.student.config;

import java.io.IOException;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Configuration
@EnableWebMvc
public class CorsWebConfig implements Filter,WebMvcConfigurer {



    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) {
      HttpServletResponse response = (HttpServletResponse) res;
      HttpServletRequest request = (HttpServletRequest) req;
      System.out.println("WebConfig; "+request.getRequestURI());
      response.setHeader("Access-Control-Allow-Origin", "*");
      response.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
      response.setHeader("Access-Control-Allow-Headers", "Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With,observe");
      response.setHeader("Access-Control-Max-Age", "3600");
      response.setHeader("Access-Control-Allow-Credentials", "true");
      response.setHeader("Access-Control-Expose-Headers", "Authorization");
      response.addHeader("Access-Control-Expose-Headers", "responseType");
      response.addHeader("Access-Control-Expose-Headers", "observe");
      System.out.println("Request Method: "+request.getMethod());
      if (!(request.getMethod().equalsIgnoreCase("OPTIONS"))) {
          try {
              chain.doFilter(req, res);
          } catch(Exception e) {
              e.printStackTrace();
          }
      } else {
          System.out.println("Pre-flight");
          response.setHeader("Access-Control-Allow-Origin", "*");
          response.setHeader("Access-Control-Allow-Methods", "POST,GET,DELETE,PUT");
          response.setHeader("Access-Control-Max-Age", "3600");
          response.setHeader("Access-Control-Allow-Headers", "Access-Control-Expose-Headers"+"Authorization, content-type," +
          "USERID"+"ROLE"+
                  "access-control-request-headers,access-control-request-method,accept,origin,authorization,x-requested-with,responseType,observe");
          response.setStatus(HttpServletResponse.SC_OK);
      }

    }


}
