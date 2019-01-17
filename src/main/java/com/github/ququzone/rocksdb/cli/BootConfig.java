package com.github.ququzone.rocksdb.cli;

import org.rocksdb.RocksDB;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;

/**
 * @author Yang XuePing
 */
@Configuration
public class BootConfig {
    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            RocksDB rocksDB = RocksDBUtils.openDB(System.getProperty("user.dir") + File.separator + "cache.db");
            rocksDB.put("lastBlock".getBytes(), String.valueOf(5850000).getBytes());
        };
    }
}
