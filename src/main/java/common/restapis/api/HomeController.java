package common.restapis.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
@RestController
public class HomeController {

    @GetMapping("/")
    public void home(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession(false);

        if (session == null) {
            log.info("로그인 되지 않았습니다.");
            return;
        }
        log.info("로그인 되었습니다.");

    }
}
