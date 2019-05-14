package cn.pinghu.springboot_web_jsp.utils.Data;

/**
 * 数据结构抽象概念接口set 实现(树形数据结构实现set集合数据结构抽象概念)
 * @author shenkai
 * @date 2019/5/14
 */
public class BstSet<T extends Comparable> implements Set<T> {

    private BSTree<T> bsTree;

    public BstSet() {
        this.bsTree = new BSTree<>();
    }

    @Override
    public void add(T element) {
        bsTree.add(element);
    }

    @Override
    public boolean contain(T element) {
        return bsTree.contain(element);
    }

    @Override
    public int getSize() {
        return bsTree.getSize();
    }

    @Override
    public Boolean isEmpty() {
        return bsTree.isEmpty();
    }

    @Override
    public void remove(T element) {
        bsTree.remove(element);
    }

    @Override
    public String toString() {
        return "BstSet{" +
                "bsTree=" + bsTree +
                '}';
    }

    public int uniqueMorseRepresentations(String[] words) {

        String[] codes = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        BstSet<String> set = new BstSet<>();
        for(String word: words){
            StringBuilder res = new StringBuilder();
            for(int i = 0 ; i < word.length() ; i ++)
                res.append(codes[word.charAt(i) - 'a']);

            set.add(res.toString());
        }

        return set.getSize();
    }
}
