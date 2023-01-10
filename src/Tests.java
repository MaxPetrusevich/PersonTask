package src;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.util.List;

public class Tests {
    @Test
    public void creatingListTest(){
        List<Person> list = ExecuteTask.createPersonList();
        Assert.assertTrue("List was created", list != null);
    }

    @Test
    public void streamTaskTest(){
        List<Person> list = ExecuteTask.streamTask(ExecuteTask.createPersonList());
        Assert.assertTrue("Task was executed", list != null);
    }

    @Test
    public void writeReadTest(){
        File file = new File("src\\output.bin");
        Assert.assertTrue("File can write or read", file.exists());
    }



}
