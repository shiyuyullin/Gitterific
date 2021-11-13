package model;

import junit.framework.TestCase;
import play.mvc.Result;

import java.util.concurrent.CompletionStage;

public class ProcessRepoTest extends TestCase {

    public void testProcess() {
        CompletionStage<Result> result = ProcessRepo.process("gto76","python-cheatsheet");

    }

    public void testGenerateJN() {
    }
}