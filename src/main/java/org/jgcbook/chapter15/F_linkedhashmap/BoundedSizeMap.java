package org.jgcbook.chapter15.F_linkedhashmap;
// 16f1
import java.util.Map;
import java.util.LinkedHashMap;

class BoundedSizeMap<K,V> extends LinkedHashMap<K,V> {
    private final int maxEntries;
    public BoundedSizeMap(int maxEntries) {
        super(16, 0.75f, true);
        this.maxEntries = maxEntries;
    }
    protected boolean removeEldestEntry(Map.Entry<K,V> eldest) {
        return size() > maxEntries;
    }

	private boolean isReservedKey(K keyToRetain) {return false;}
	protected boolean removeEldestEntry_1(Map.Entry<K,V> eldest) {
	    if (size() > maxEntries) {
	        for (var itr = entrySet().iterator() ; itr.hasNext() ; ) {
	            if (!isReservedKey(itr.next().getKey())) {
	                itr.remove();
	                return false;
	            }
	        }
	    }
	    return false;
	}
	protected boolean removeEldestEntry_2(Map.Entry<K,V> eldest) {
	    if (size() > maxEntries) {
	        pollLastEntry();
	    }
	    return false;
	}
	protected boolean removeEldestEntry_3(Map.Entry<K,V> eldest) {
	   if (size() > maxEntries) {
	       for (var itr = sequencedKeySet().reversed().iterator() ; itr.hasNext() ; ) {
	           if (!isReservedKey(itr.next())) {
	               itr.remove();
	               return false;
	           }
	       }
	   }
	   return false;
	}
}