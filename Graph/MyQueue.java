public  class MyQueue {
    private int[] arr;
    private int front;
    private int rear;
    private int capacity;
     private int count;
                              //Array to store queue elements
                              //Front points to the front element in the
                                                                             //queue
                              //Rear points to the last element in the
                                                                           //queue
                              //Maximum capacity of the queue
                              //Current size of the queue
     /**
        Constructor
        eparam size
     **/
      MyQueue(int size) {
          arr = new int[size];
          capacity = size;
          front = 0;
          rear = -1;
          count = 0;
     }
          /*Dequeue the front element
          @return Node*/
       public int poll () {
//Check forqueue underflow
                       
           if (isEmpty()) {

                System.out.println("Underflow\nProgran Terminated");
                System.exit(-1);
           }
            int x = arr[front];
            
            front = (front + 1) % capacity;
                                 
             count--;
             return x;
    
        }
public void add (int item)
                                {
   // check for queue overflow
     if (isFull())
    {
        System.out.println("Overflow\nProgram Terminated");
         System.exit(-1);
     rear =  (rear + 1) % capacity;
     arr[rear] = item;
     count++;}
    }
    /*Gets the size of the
                          queue
    ereturn int*/
  public int getSize() {
      return count;
  }
  /**
     Check if the queue is
                           empty or not
     @return boolean
     */
  public boolean isEmpty() {
       return (getSize() == 0);}
     /* Check if the queue is full
                                or not
      @return boolean*/
   public boolean isFull() {
        return (getSize() == capacity);
   }

 }