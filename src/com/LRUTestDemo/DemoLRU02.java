package com.LRUTestDemo;

import java.util.HashMap;
import java.util.Map;

public class DemoLRU02 {
    //map负责查找，构建一个虚拟双向链表里面是一个个node节点，node节点为数据载体
    //创造内部类Node
    class Node<k,v>{
        k key;
        v value;
        Node<k,v> prev;
        Node<k,v> next;

        public Node() {
            this.prev = this.next = null;
        }

        public Node(k key, v value) {
            this.key = key;
            this.value = value;
            this.prev = this.next = null;
        }
    }
    //构建虚拟的双向链表：
    class DoubleLinkedList<k,v>{
        Node<k,v> head;
        Node<k,v> tail;
        //构造方法,构成头尾衔接的双向虚拟链表，头和尾都为空Node
        public DoubleLinkedList() {
            this.head = new Node<>();
            this.tail = new Node<>();
            head.next=tail;
            tail.prev=head;
        }
        //添加到头：
        public void addHead(Node<k,v> node){
            node.next=head.next;
            node.prev=head;
            head.next.prev=node;
            head.next=node;
        }
        //删除节点：
        public void removeNode(Node<k,v> node){
            node.next.prev=node.prev;
            node.prev.next=node.next;
            node.next=null;
            node.prev=null;
        }
        //获得最后一个节点：
        public Node<k,v> getLast(){
            return tail.prev;
        }
        public void listprint(){
            Node<k,v> p=head;
            while (p!=null){
                System.out.println(p.key+"===="+p.value);
                p=p.next;
            }
        }
    }

    private  int cacheSize;
    Map<Integer,Node<Integer,Integer>> map;
    DoubleLinkedList<Integer,Integer> doubleLinkedList;

    public DemoLRU02(int cacheSize) {
        this.cacheSize = cacheSize;
        map=new HashMap<>();
        doubleLinkedList=new DoubleLinkedList<>();
    }
    public int get(int key){
        doubleLinkedList.listprint();
        if (!map.containsKey(key)){
            return -1;
        }
        Node<Integer,Integer> node=map.get(key);
        doubleLinkedList.removeNode(node);
        doubleLinkedList.addHead(node);
        return node.value;
    }
    public void put(int key,int value){

        if(map.containsKey(key)){ doubleLinkedList.listprint();
            Node<Integer,Integer> node=map.get(key);
            node.value=value;
            map.put(key,node);
            doubleLinkedList.removeNode(node);
            doubleLinkedList.addHead(node);
        }else {
            if(map.size()==cacheSize){//满员，删除最后一个
                doubleLinkedList.listprint();
                Node<Integer,Integer> lastNode=doubleLinkedList.getLast();
                map.remove(lastNode.value);
                doubleLinkedList.removeNode(lastNode);
            }
            //新增：放入map集合，并将节点放入链表头部：
            Node<Integer,Integer> newNode=new Node<>(key,value);
            map.put(key,newNode);
            doubleLinkedList.addHead(newNode);
            doubleLinkedList.listprint();
        }
    }
    public static void main(String[] args){
    DemoLRU02 demoLRU02=new DemoLRU02(3);
        demoLRU02.put(1,1);
        demoLRU02.put(2,1);
        demoLRU02.put(3,1);
        System.out.println(demoLRU02.map.entrySet());
        demoLRU02.put(4,4);
        System.out.println(demoLRU02.map.entrySet());
        demoLRU02.put(3,3);
        System.out.println(demoLRU02.map.entrySet());
        demoLRU02.put(3,3);
        System.out.println(demoLRU02.map.entrySet());
        demoLRU02.put(3,3);
        System.out.println(demoLRU02.map.entrySet());
        demoLRU02.put(5,5);
        System.out.println(demoLRU02.map.entrySet());
    }
}
