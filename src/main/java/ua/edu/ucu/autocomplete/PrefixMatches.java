package ua.edu.ucu.autocomplete;

import ua.edu.ucu.tries.Trie;
import ua.edu.ucu.tries.Tuple;

/**
 *
 * @author andrii
 */
public class PrefixMatches {

    private Trie trie;

    public PrefixMatches(Trie trie){
        this.trie = trie;
    }

    public int load(String... strings) {
        for (String s: strings) {
            for (String newS : s.split(" ")) {
                if (newS.length() >= 2) {
                    this.trie.add(new Tuple(newS, newS.length()));
                }
            }
        }
        return this.size();
    }

    public boolean contains(String word) {
        return this.trie.contains(word);
    }

    public boolean delete(String word) {
        return this.trie.delete(word);
    }

    public Iterable<String> wordsWithPrefix(String pref) {
        if (pref.length() <= 2) {
            return null;
        }
        else {
            return trie.wordsWithPrefix(pref);
        }
    }

    public Iterable<String> wordsWithPrefix(String pref, int k) {
        return null;
    }

    public int size() {
        return this.trie.size();
    }
}
