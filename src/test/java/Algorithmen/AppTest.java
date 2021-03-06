/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package Algorithmen;

import Algorithmen.hash.Hash;
import Algorithmen.hash.IHash;
import Algorithmen.main.ADSHashTable;
import Algorithmen.main.App;
import Algorithmen.main.HashInvoker;
import Algorithmen.probing.QuadraticProbing;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class AppTest {

    private static final int TEST_SIZE = 5;
    ADSHashTable test_table = new ADSHashTable(TEST_SIZE, new Hash(TEST_SIZE), new QuadraticProbing());

    @Test
    public void insertTest() {
        HashInvoker.insert(test_table, 55);
        HashInvoker.insert(test_table, 13);
        //expecting collision. The key will be found at 4
        HashInvoker.insert(test_table, 23);
        Assert.assertEquals(55, test_table.getHashArray().get(0));
        Assert.assertEquals(13, test_table.getHashArray().get(3));
        Assert.assertEquals(23, test_table.getHashArray().get(4));
    }

    @Test
    public void removeTest() {
        HashInvoker.insert(test_table, 55);
        HashInvoker.remove(test_table, 55);
        //was deleted and I can add a new number there
        HashInvoker.insert(test_table, 35);
        Assert.assertEquals(35, test_table.getHashArray().get(0));
    }
}
