package org.apache.impala.helloworld;

import org.apache.impala.analysis.Parser;
import org.apache.impala.analysis.StatementBase;
import org.apache.impala.service.BackendConfig;
import org.apache.impala.thrift.TBackendGflags;

public class Main {
  public static void main(String[] args) throws Exception {
    if (args.length < 1) {
      System.err.println("Args: impala_sql_text");
      System.exit(1);
    }
    String sql = args[0];
    System.out.println("Parsing " + sql);

    TBackendGflags cfg = new TBackendGflags();
    cfg.setSkip_lookup_symbol(true);
    BackendConfig.create(cfg);

    StatementBase node = Parser.parse(sql);
    System.out.println("StatementType: " + node.getClass());
    System.out.println("toSql: " + node.toSql());
  }
}