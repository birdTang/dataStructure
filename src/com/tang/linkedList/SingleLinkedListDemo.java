package com.tang.linkedList;

/**
 * 单链表
 * @author tangpeng
 *
 */
public class SingleLinkedListDemo {
	public static void main(String[] args) {
		HeroNode node1 = new HeroNode(1, "宋江","及时雨");
		HeroNode node2 = new HeroNode(2, "卢俊义","玉麒麟");
		HeroNode node3 = new HeroNode(4, "吴用","智多星");
		HeroNode node4 = new HeroNode(3, "林冲","豹子头");
		
		SingleLinkedList singleLinkedList = new SingleLinkedList();
		singleLinkedList.add2(node1);
		singleLinkedList.add2(node2);
		singleLinkedList.add2(node3);
		singleLinkedList.add2(node4);
		singleLinkedList.list();
		System.out.println("=================================");

//		//修改
//		HeroNode updNode = new HeroNode(5,"宋江1", "及时雨1");
//		singleLinkedList.update(updNode);
//		singleLinkedList.list();
//		System.out.println("=================删除后================");
//		//删除
//		singleLinkedList.delete(5);
//		singleLinkedList.list();
//		
//		//获取长度
//		System.out.println("链表长度："+ singleLinkedList.size(singleLinkedList.getHead()));
//		
//		//获取倒数第K个节点
//		HeroNode lastKNode = singleLinkedList.getLastKNode(singleLinkedList.getHead(), 10);
//		
//		System.out.println("倒数第k个节点："+lastKNode);
		
		//单链表反转
		System.out.println("=================反转后================");
		singleLinkedList.reverse2(singleLinkedList.getHead());
		singleLinkedList.list();
		
		
	}
}

class SingleLinkedList {
	private HeroNode head = new HeroNode(0, null, null);
	
	
	public HeroNode getHead() {
		return head;
	}

	public void add(HeroNode node) {
		HeroNode temp = head;
		//查找尾节点插入
		while(temp.getNext()!=null) {
			temp = temp.getNext();
		}
		
		temp.setNext(node);
	}
	
	//按no从小到大插入
	public void add2(HeroNode heroNode) {
		HeroNode temp = head;
		boolean exist = false;
		while(true) {
			if(temp.getNext()==null) {
				break;
			}
			
			if(temp.getNext().getNo()> heroNode.getNo()) {
				break;
			}else if(temp.next.getNo()==heroNode.getNo()) {
				exist = true;
				break;
			}
			temp =temp.next;
		}
		if(exist) {
			System.out.printf("数据编号%d已存在,不能加入\n",heroNode.getNo());
			return;
		}
		heroNode.next = temp.next;
		temp.next = heroNode;
	}
	
	//修改，假设需求是：no不能修改
	public void update(HeroNode node) {
		if(head.next==null) {
			System.out.println("链表为空");
			return;
		}
		HeroNode temp = head;
		boolean exist = false;
		while(true) {
			if(temp.next==null) {
				break;
			}
			if(temp.getNo()==node.getNo()) {
				exist = true;
				break;
			}
			temp = temp.next;
		}
		if(exist) {
			temp.setName(node.getName());
			temp.setNickName(node.getNickName());
		}else {
			System.out.printf("数据不存在,编号为%d\n",node.getNo());
		}
	}
	
	public void delete(int no) {
		if(head.next==null) {
			return;
		}
		HeroNode temp = head;
		boolean exist = false;
		while(temp.next!=null) {
			if(temp.next.getNo()==no) {
				exist = true;
				break;
			}
			temp = temp.next;
		}
		if(exist) {
			temp.next = temp.next.next;
		}else {
			System.out.printf("数据不存在%d\n",no);
		}
	}
	
	//获取链表长度
	public int size(HeroNode head) {
		if(head.next==null) {
			return 0;
		}
		HeroNode temp = head.next;
		int length = 0;
		while(temp!=null) {
			length++;
			temp = temp.next;
		}
		return length;
	}
	
	//获取倒数第K个节点
	public HeroNode getLastKNode(HeroNode head,int k) {
		if(head.next==null) return null;
		int size = size(head);
		//数据校验
		if(k<=0 || k>size) {
			return null;
		}
		
		HeroNode temp = head.next;
		for(int i=0;i<size-k;i++) {
			temp = temp.next;
		}
		return temp;
	}
	
	//单链表反转
	public void reverse(HeroNode head) {
		//链表为空，或只有一个节点，直接返回
		if(head.next==null || head.next.next==null) return;
		
		//定义一个辅助指针，用来遍历原链表
		HeroNode cur = head.next;
		HeroNode next = null; //指向当前节点的下一个节点
		HeroNode reverseNode = new HeroNode(0, null, null); //定义一个空链表
	
		while(cur!=null) {
			next = cur.next;
			cur.next = reverseNode.next;
			reverseNode.next = cur;
			cur = next;
		}
		//将head.next 指向reverseNode的next;
		head.next = reverseNode.next;
	}
	
	//逆序打印单链表
	public void reverseList(HeroNode head) {
	}
	
	public void reverse2(HeroNode head) {
		//链表为空，或只有一个节点，直接返回
		if(head.next==null || head.next.next==null) return;
		
		HeroNode cur = head.next;
		HeroNode pre = null;
		HeroNode next = null; 
		 while(cur!=null) {
			 next = cur.next;
			 //next为null，则遍历到尾结点了，直接反转为头节点
			 if(next==null) {
				 head.next = cur;
			 }
			 
			 cur.next = pre;
			 pre = cur;
			 cur = next;
		 }
	}
	
	//有序列表的合并
	public HeroNode mergeSortLists(HeroNode a,HeroNode b) {
		if(b==null) return a;
		if(a==null) return b;
		
		HeroNode first = null;
		HeroNode p = a;
		HeroNode q = b;
		if(p.next.getNo()<q.next.getNo()) {
			first = p;
			p = p.next;
		}else {
			first = q;
			q = q.next;
		}
		
		HeroNode r = first;
		while(p!=null && q!=null) {
			if(p.next.getNo()<q.next.getNo()) {
				r.next = p;
				p = p.next;
			}else {
				r.next = q;
				q = q.next;
			}
			r = r.next;
		}
		//没比较完的直接加入到结点尾部
		if(p.next!=null) {
			r.next = p;
		}
		if(q.next!=null) {
			r.next = q;
		}
		return first;
		
	}
	
	public void list() {
		HeroNode temp = head.getNext();
		while(true) {
			if(temp==null) {
				break;
			}
			System.out.println(temp);
			temp =temp.getNext();
		}
	}
}

class HeroNode {
	private int no;
	private String name;
	private String nickName;
	public HeroNode next;
	
	
	public HeroNode(int no, String name, String nickName) {
		super();
		this.no = no;
		this.name = name;
		this.nickName = nickName;
	}
	

	public int getNo() {
		return no;
	}


	public void setNo(int no) {
		this.no = no;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getNickName() {
		return nickName;
	}


	public void setNickName(String nickName) {
		this.nickName = nickName;
	}


	public HeroNode getNext() {
		return next;
	}


	public void setNext(HeroNode next) {
		this.next = next;
	}


	@Override
	public String toString() {
		return "HeroNode [no=" + no + ", name=" + name + ", nickName="
				+ nickName + "]";
	}
}