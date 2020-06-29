package Algorithmen.main;

public class HashInvoker {
    private static final String sMsgRemoveKey = "Remove key '%d' from the hash table.";
    private static final String sMsgSearchForKey = "Search for key '%d' in the hash table.";
    private static final String sMsgSearchKeyFound = "Found key '%d' in hash table.";

    static public void insert(ADSHashTable table, int key) {
        try {
            table.insert(key);
            print(table.toString());
        } catch (Exception e) {
            flush(e);
        }
    }

    static public void search(ADSHashTable table, int key) {
        try {
            print(String.format(sMsgSearchForKey, key));
            print(String.format(sMsgSearchKeyFound, table.search(key)));
        } catch (Exception e) {
            flush(e);
        }
    }

    static public void remove(ADSHashTable table, int key) {
        try {
            print(String.format(sMsgRemoveKey, key));
            table.remove(key);
            print(table.toString());
        } catch (Exception e) {
            flush(e);
        }
    }

    static public void print(String text) {
        System.out.println(text);
        System.out.flush();
    }

    static public void clear(ADSHashTable table){
        table.clear();


    }

    static private void flush(Exception e) {
        System.out.flush();
        System.err.println(e.getMessage());
        System.err.flush();
    }
}
