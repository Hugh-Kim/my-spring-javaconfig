package org.my.study;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by HughKim on 2016-11-11.
 */
@Controller
@RequestMapping("/test")
@Slf4j
public class StudyViewController {

    @RequestMapping(path = "/alert", method = RequestMethod.GET)
    public String callAlertTemplate(Model model) {
        log.info("call alert template.");
        model.addAttribute("message", "hello scriptTemplate!");
        return "alert_template";
    }
}
