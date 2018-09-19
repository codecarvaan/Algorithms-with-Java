class Node{
   private int data;
   private Node nextNode;
    Node(){
        data=0;
        nextNode=null;
    }
    public int getData() {
        return data;
    }
    public Node getNextNode(){
        return nextNode;
    }
    public void  setData(int data)
    {
        this.data=data;
    }
    public void setNextNode(Node nextNode){
        this.nextNode=nextNode;
    }
 }
    class LinkedList{
       private int size;
       private Node startNode;
       private Node currentNode;
        
       LinkedList(){
            size=0;
            startNode=null;
            currentNode=null;
        }
        public void add(int data){
            Node newNode=new Node();
            newNode.setData(data);
            newNode.setNextNode(null);
            
            if(size==0)
            {
                startNode=newNode;
                currentNode=startNode;
               
            }
            else{
                currentNode.setNextNode(newNode);
                currentNode=newNode;  
               
            }
            size++;
        }
        public void addStart(int data)
        {
            if(size!=0)
            {
            Node newNode=new Node();
            newNode.setData(data);
            newNode.setNextNode(startNode);
            startNode=newNode;
            size++;}
            else{
                add(data);
            }
        }
        public void addAt(int pos,int data) 
        {   Node itr=startNode;
            if(!(pos>0 && pos<size))
            { System.out.println("invalid");
                return;}
            
            Node newNode=new Node();
            newNode.setData(data);
            for(int i=1;i<pos;i++)
            {   
                itr=itr.getNextNode();
            }
            newNode.setNextNode(itr.getNextNode());
            itr.setNextNode(newNode);
            size++;
        }

        public void deleteAt(int pos) 
        {   Node itr=startNode;
            size--;
            if(!(pos>=0 && pos<=size))
            { System.out.println("invalid");
                return;}
            if(pos==0)
            {
                startNode=startNode.getNextNode();
                return;
            }
            
           
            for(int i=0;i<pos-1;i++)
            {   
                itr=itr.getNextNode();
            }
           
            itr.setNextNode(itr.getNextNode().getNextNode());
           
        }
        
        public void getList(){
            Node itr=startNode;
            for(int i=0;i<size;i++)
            {   
                System.out.println(itr.getData());
                itr=itr.getNextNode();
            }
        }
    }
    class LinkedListExample{
        public static void main(String rgs[]){
            LinkedList list=new LinkedList();
            
            list.addStart(12);
            list.add(43);
            list.add(56);
            list.add(34);
            list.addAt(2,55);
            list.deleteAt(4);
            list.getList();    
        }
    }
    
