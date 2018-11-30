package com.cts.fasttack.admin.web.config;

import com.cts.fasttack.admin.web.data.menu.MenuItem;
import com.cts.fasttack.admin.web.data.menu.MenuItemRepository;
import com.cts.fasttack.admin.web.security.acl.Acl;
import com.cts.fasttack.admin.web.security.acl.AclAccessLog;
import com.cts.fasttack.admin.web.security.acl.AclBinSetup;
import com.cts.fasttack.admin.web.security.acl.AclChangeLog;
import com.cts.fasttack.admin.web.security.acl.AclEncKey;
import com.cts.fasttack.admin.web.security.acl.AclFEProp;
import com.cts.fasttack.admin.web.security.acl.AclMessageHistory;
import com.cts.fasttack.admin.web.security.acl.AclMonitoring;
import com.cts.fasttack.admin.web.security.acl.AclRole;
import com.cts.fasttack.admin.web.security.acl.AclToken;
import com.cts.fasttack.admin.web.security.acl.AclUser;
import com.cts.fasttack.admin.web.security.acl.AclCardProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.util.List;

/**
 * @author Olexandr Lypivets
 */
@Configuration
public class MenuItemConfig {

    @Autowired
    private List<MenuItem> items;

    @Bean
    @Order(1)
    public MenuItem MonitoringMenuItem(AclMonitoring aclMonitoring){
        return createItem("common.menu.monitoring", "/monitoring.htm", "fa fa-dashboard fa-fw", aclMonitoring);
    }

    @Bean
    @Order(2)
    public MenuItem TokenMenuItem(AclToken aclToken){
        return createItem("common.menu.token", "/token/list.htm?filter.clear=true", "fa fa-credit-card fa-fw", aclToken);
    }

    @Bean
    @Order(3)
    public MenuItem RoleItem(AclRole aclRole){
        return createItem("common.menu.role", "/role/list.htm", "fa fa-users fa-fw", aclRole);
    }

    @Bean
    @Order(4)
    public MenuItem UserMenuItem(AclUser aclUser){
        return createItem("common.menu.users", "/user/list.htm?filter.clear=true", "fa fa-user fa-fw", aclUser);
    }

    @Bean
    @Order(5)
    public MenuItem MessageHistoryMenuItem(AclMessageHistory aclMessageHistory){
        return createItem("common.menu.systemLog", "/messageHistory/list.htm?filter.clear=true", "fa fa-list-alt", aclMessageHistory);
    }

    @Bean
    @Order(6)
    public MenuItem ChangeLogMenuItem(AclChangeLog aclChangeLog){
        return createItem("changeLog.title", "/changeLog/list.htm?filter.clear=true", "fa fa-pencil-square-o", aclChangeLog);
    }

    @Bean
    @Order(7)
    public MenuItem AccessLogMenuitem(AclAccessLog aclAccessLog){
        return createItem("accessLog.title", "/accessLog/list.htm?filter.clear=true", "fa fa-pencil-square-o", aclAccessLog);
    }

    @Bean
    @Order(8)
    public MenuItem EncKeyMenuItem(AclEncKey aclEncKey){
        return createItem("common.menu.enckey", "/enckey/list.htm?filter.clear=true", "fa fa-key", aclEncKey);
    }

    @Bean
    @Order(9)
    public MenuItem FePropMenuItem(AclFEProp aclFEProp){
        return createItem("common.menu.feProp", "/feProp/list.htm", "fa fa-pencil-square-o", aclFEProp);
    }

    @Bean
    @Order(10)
    public MenuItem BinSetupMenuItem(AclBinSetup aclBinSetup){
        return createItem("common.menu.bin", "/bin/list.htm?filter.clear=true", "fa fa-cog fa-fw", aclBinSetup);
    }

    @Bean
    @Order(11)
    public MenuItem CardProductMenuItem(AclCardProduct aclCardProduct){
        return createItem("common.menu.cardproduct", "/cardProduct/list.htm", "fa fa-cog fa-fw", aclCardProduct);
    }

    private MenuItem createItem(String caption, String url, String style, Acl acl){
        return new MenuItem().caption(caption).url(url).cssStyle(style).acl(acl);
    }

    @Bean
    public MenuItemRepository menuItemRepository() {
        MenuItemRepository menuItemRepository = new MenuItemRepository();
        menuItemRepository.setItems(this.items);
        return menuItemRepository;
    }
}
