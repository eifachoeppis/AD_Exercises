/*
 * Copyright 2020 Hochschule Luzern Informatik.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ch.hslu.ad.sw11.findfile;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

/**
 * Codevorlage für eine Dateisuche.
 */
public final class DemoFindFile {

    private static final Logger LOG = LogManager.getLogger(DemoFindFile.class);

    /**
     * Privater Konstruktor.
     */
    private DemoFindFile() {
    }

    /**
     * Main-Demo.
     *
     * @param args not used.
     */
    public static void main(String[] args) {
        long start;
        long end;
        final String search = "gugus";//"find.me";
        final File rootDir = new File(System.getProperty("user.home"));
        LOG.info("Start searching '" + search + "' recursive in '" + rootDir + "'");
        start = System.nanoTime();
        FindFile.findFile(search, rootDir);
        end = System.nanoTime();
        LOG.info("Found in " + String.format("%,d", (end - start) / 1_000_000) + " ms.");
        LOG.info("Find " + search + " concurrent in " + rootDir);
        final FindFileTask root = new FindFileTask(search, rootDir);
        start = System.nanoTime();
        LOG.info(root.invoke());
        end = System.nanoTime();
        LOG.info("Found in " + String.format("%,d", (end - start) / 1_000_000) + " ms.");
    }
}
