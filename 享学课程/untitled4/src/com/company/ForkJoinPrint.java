package com.company;

import java.io.File;
import java.util.*;
import java.util.concurrent.RecursiveTask;

public class ForkJoinPrint extends RecursiveTask<HashSet<String>> {

    private File file;

    public ForkJoinPrint(File file){
        this.file = file;
    }

    @Override
    protected HashSet<String> compute() {

        List<ForkJoinPrint> list = new ArrayList<>();

        if (file == null){
            return null;
        }
        File[] files = file.listFiles();
        if (files == null){
            return null;
        }
        HashSet<String> fileHashSet = new HashSet<>();
        for (File file1 : files) {
            if (file1.isFile() && file1.getAbsolutePath().endsWith(".java")){
                fileHashSet.add(file1.getAbsolutePath());
                System.out.println(file1.getAbsolutePath());
            } else if (file1.isDirectory()){
                ForkJoinPrint forkJoinPrint = new ForkJoinPrint(file1);
                list.add(forkJoinPrint);
            }
        }
        if (list.size() != 0){
            for (ForkJoinPrint forkJoinPrint : invokeAll(list)) {
                HashSet<String> join = forkJoinPrint.join();
                fileHashSet.addAll(join == null ? new HashSet<>() : join);
            }
        }
        return fileHashSet;
    }

}
