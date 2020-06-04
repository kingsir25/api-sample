package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * DBUnitテストのmainを持つクラス。
 * @author tarosa0001
 */
public class TestMain {
  /** ロガー */
  private static Logger logger = LoggerFactory.getLogger(TestMain.class);

  /** 実行するSQL */
  private static final String SQL
      = " update "
      + "       EMP "
      + "   set "
      + "       name = 'tiger' "
      + "   where "
      + "       id = 1";

  /**
   * @param args
   */
  public static void main(String[] args) {
    logger.info("処理開始");

    // ---------------------------------
    // DBを更新する
    // ---------------------------------

    try(Connection conn = DriverManager.getConnection(
        "jdbc:mysql://127.0.0.1:3306/test_schema?useUnicode=true&characterEncoding=utf-8&serverTimezone=UTC&useSSL=true", "root", "admin");
        PreparedStatement stmt = conn.prepareStatement(SQL);
        ) {
      conn.setAutoCommit(false);
      int i = stmt.executeUpdate();

      // 処理件数を表示する
      logger.info("処理件数:[" + i + "]");

      conn.commit();
    } catch(Exception e) {
      logger.error("エラー", e);
    }

    logger.info("処理終了");
  }
}