package com.github.ququzone.rocksdb.cli;

import lombok.extern.slf4j.Slf4j;
import org.rocksdb.Options;
import org.rocksdb.RocksDB;
import org.rocksdb.RocksDBException;

/**
 * RocksDB utils.
 *
 * @author Yang XuePing
 */
@Slf4j
public class RocksDBUtils {
    static {
        RocksDB.loadLibrary();
    }

    public static RocksDB openDB(String db) {
        try (final Options options = new Options().setCreateIfMissing(true)) {
            return RocksDB.open(options, db);
        } catch (RocksDBException e) {
            log.error("create RocksDB instance error", e);
            return null;
        }
    }
}
