package com.cts.fasttack.admin.web.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.cts.fasttack.admin.web.service.UserService;

/**
 * Scheduler which periodically blocks users or need to change password whose password is overdue
 * @author a.lipavets
 */
@Component
public class UserScheduler {

    @Autowired
    private UserService userService;

    @Scheduled(cron = "${spring.admin.web.security.blockUserCron}")
    public void blockOverdueUserOrResetPassword(){
        userService.blockOverdueUserOrResetPassword();
    }
}
