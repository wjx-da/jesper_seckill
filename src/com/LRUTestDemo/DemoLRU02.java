package com.LRUTestDemo;

import java.util.HashMap;
import java.util.Map;

public class DemoLRU02 {
    //map������ң�����һ������˫������������һ����node�ڵ㣬node�ڵ�Ϊ��������
    //�����ڲ���Node
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
    //���������˫������
    class DoubleLinkedList<k,v>{
        Node<k,v> head;
        Node<k,v> tail;
        //���췽��,����ͷβ�νӵ�˫����������ͷ��β��Ϊ��Node
        public DoubleLinkedList() {
            this.head = new Node<>();
            this.tail = new Node<>();
            head.next=tail;
            tail.prev=head;
        }
        //��ӵ�ͷ��
        public void addHead(Node<k,v> node){
            node.next=head.next;
            node.prev=head;
            head.next.prev=node;
            head.next=node;
        }
        //ɾ���ڵ㣺
        public void removeNode(Node<k,v> node){
            node.next.prev=node.prev;
            node.prev.next=node.next;
            node.next=null;
            node.prev=null;
        }
        //������һ���ڵ㣺
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
            if(map.size()==cacheSize){//��Ա��ɾ�����һ��
                doubleLinkedList.listprint();
                Node<Integer,Integer> lastNode=doubleLinkedList.getLast();
                map.remove(lastNode.value);
                doubleLinkedList.removeNode(lastNode);
            }
            //����������map���ϣ������ڵ��������ͷ����
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
