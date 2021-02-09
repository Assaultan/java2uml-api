package org.java2uml.java2umlapi.util.unzipper;

import org.apache.commons.io.FileDeleteStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.fail;

class UnzipperTest {

    private static final String SRC = "src/test/testSources/JavaParserFacadeTests/testParserClass/ProjectTest/thymeleaf-demo-thymeleaf-demo.zip";
    private static final String DST = "src/test/testOutput";

    @Test
    @DisplayName("When using Unzipper, unzips files from SRC path and generate output in DST path.")
    void testUnzipDir()  throws IOException {
        File destDir = Unzipper.unzipDir(Path.of(SRC), Path.of(DST));

        if (Files.notExists(destDir.toPath())) {
            fail("Unzipped Directory not found.");
        }

        //clean up.
        FileDeleteStrategy.FORCE.delete(destDir);
    }
}