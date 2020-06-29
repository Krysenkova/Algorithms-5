package Algorithmen.main;

import Algorithmen.hash.IHash;
import Algorithmen.probing.IProbing;

public class ADSHashTable {
    private int size;
    private IHash hashAlgorithm;
    private IProbing probingAlgorithm;
    private HashArray hashArray;

    public ADSHashTable(int size, IHash hashAlgorithm, IProbing probingAlgorithm) {
        super();
        this.size = size;
        this.hashAlgorithm = hashAlgorithm;
        this.probingAlgorithm = probingAlgorithm;
        this.hashArray = new HashArray(size);
    }

    private static final String sExceptionNoSpaceFree = "No free space in hash table for key %d !";
    private static final String sMsgKeyInserAt = "Key '%d' inserted at index '%d' in hash table";
    private static final String sMsgCollision = "Increment collsion counter j++ -> %d : [index=%d, key=%d]";
    private static final String sMsgKeyMarkedAsDeleted = "Key '%d' mark as deleted at index '%d' in hash table.";
    private static final String sExceptionKeyNotFound = "Key '%d' not found in hash table";

    void insert(int key) throws Exception {
        int j = 0;
        int hashValue = hashAlgorithm.hash(key);
        do {
            int addr = calculateIndex(hashValue, key, j);
            if (hashArray.isFree(addr) || hashArray.isMarkedAsDeleted(addr)) {
                hashArray.set(addr, key);
                debug(String.format(sMsgKeyInserAt, key, addr));
                return;
            }
            j++;
        } while (j < size);
        throw new Exception(String.format(sExceptionNoSpaceFree, key));

    }

    void remove(int key) throws Exception {
        int j = 0;
        int hashValue = hashAlgorithm.hash(key);
        do {
            int addr = (hashValue - probingAlgorithm.probe(key, j));
            if (hashArray.isFree(addr)) {
                break;
            }
            if (hashArray.compareKeys(addr, key)) {
                hashArray.markAsDeleted(addr);
                debug(String.format(sMsgKeyMarkedAsDeleted, key, addr));
                return;
            }
            j++;
            debug(String.format(sMsgCollision, j, addr, this.hashArray.get(addr)));
        } while (j < size);
        throw new Exception(String.format(sExceptionKeyNotFound, key));

    }

    int search(int key) throws Exception {
        int j = 0;
        int hashValue = hashAlgorithm.hash(key);
        do {
            int addr = calculateIndex(hashValue, key, j);
            if (hashArray.isFree(addr)) {
                break;
            }
            if (hashArray.compareKeys(addr, key)){
                return hashArray.get(addr);
            }
            j++;
        } while (j < size);
        throw new Exception(String.format(sExceptionKeyNotFound, key));
    }

    void clear() {
        this.hashArray.clear();

    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(hashAlgorithm.toString());
        builder.append(" method with ");
        builder.append(probingAlgorithm.toString());
        builder.append(" - Hashtable - ");
        builder.append(hashArray);
        return builder.toString();
    }

    private int calculateIndex(int hashValue, int key, int j) {
        return Math.floorMod(hashValue - probingAlgorithm.probe(key, j), size);
    }

    private boolean debug = false;

    void debug(String s) {
        if (debug) {
            System.out.println(" " + s);
            System.out.flush();
        }
    }
}

