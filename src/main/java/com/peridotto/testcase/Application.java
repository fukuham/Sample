/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.peridotto.testcase;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tada.doma2.dao.UserinfoDao;
import com.tada.doma2.dao.UserinfoDaoImpl;
import com.tada.doma2.entity.Userinfo;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import org.seasar.doma.jdbc.tx.TransactionManager;

/**
 *
 * @author fukuham
 */
public class Application {

    public static void main(String args[]) throws IOException {
        // JSON読み込みサンプル
        Application ins = new Application();
        System.out.println("inFilename:" + ins.getProp().getTargetFileName());
        System.out.println("outFilename:" + ins.getProp().getOutputFileName());

        // DOMAサンプル
        TransactionManager tm = AppConfig.singleton().getTransactionManager();
        tm.required(() -> {
            UserinfoDao dao = new UserinfoDaoImpl();
            Userinfo info = new Userinfo();
            info.setName("fukuham");
            info.setAge(BigDecimal.valueOf(32));
            dao.insert(info);
        });

    }

    // アプリケーション全体のプロパティファイル(仮)
    private ApplicationParameteｒ prop;

    public ApplicationParameteｒ getProp() {
        return prop;
    }

    public Application() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        prop = mapper.readValue(new File("src\\main\\resources\\testcaseProperties.json"), ApplicationParameteｒ.class);
    }

}
