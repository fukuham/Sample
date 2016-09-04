/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.peridotto.testcase;

/**
 * アプリケーション全体のパラメタを保持するBean
 * @author fukuham
 */
public class ApplicationParameteｒ {

    // テストケース作成対象ファイル名
    private String targetFileName;
    // テストケース出力対象ファイル名
    private String outputFileName;
    
    public void setTargetFileName(String targetFileName) {
        this.targetFileName = targetFileName;
    }

    public void setOutputFileName(String outputFileName) {
        this.outputFileName = outputFileName;
    }

    public String getTargetFileName() {
        return targetFileName;
    }

    public String getOutputFileName() {
        return outputFileName;
    }


}
