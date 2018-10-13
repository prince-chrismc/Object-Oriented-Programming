package A3;

import java.util.NoSuchElementException;

public class OrderBook implements anonymous {
    private int size;        // number of elements on list
    private Node start;     // current order

    /** Only to initialize a book
     * @param pre is new node linked to last
     * @param post is new node linked to first
     */
    public OrderBook() 
    {
        this.start = new Node();
        this.size = 0;
    }

    /** 
     * linked list node helper data type
     */
    private class Node 
    {
        private Order order;
        private Node next;
        private Node prev;
        
        /**
         * Null constructor
         */
        public Node()
        {
        	this.order = null;
            this.next = null;
            this.prev = null;
        }
        
        /**
         * default constructor
         * @param order new order
         * @param next next order
         * @param prev previous order
         */
        public Node(Order order, Node next, Node prev)
        {
            this.order = order;
            this.next = next;
            this.prev = prev;
        }
        /** Function to set link to next node 
         * @param next node to be related
         */
        public void setLinkNext(Node next)
        {
        	
            this.next = next;
        }
        /* Function to set link to previous node */
        public void setLinkPrev(Node prev)
        {
            this.prev = prev;
        }
        
        /** Function to get link to next node 
         * @return next node linked
         */
        public Node getLinkNext()
        {
            return this.next;
        }
        /** Function to get link to previous node 
         * @return previous node linked
         */
        public Node getLinkPrev()
        {
            return this.prev;
        }
        
        /** Function to get data from node 
         * @return the order of node
         */
        public Order getOrder()
        {
            return this.order;
        }
        /** 
         * @return the price of order in node
         */
        public double getOrderPrice()
        {
        	if(this.getOrder() == null) throw new NoSuchElementException();
        	return this.order.getPrice();
        }
        
        public boolean hasNext()
        {
			return this.getLinkNext() != null;
        }
        public boolean hasPrevious()
        {
			return this.getLinkPrev() != null;
        }
        
        public void addBefore(Node current)
        {
        	if(!current.hasPrevious()) //if no next node
            {
            	this.setLinkNext(current); //new node is set to previous as current
            	current = new Node(current.getOrder(), null, this); //current is updated with new node as previous
            	return;
            }
        	else if(current.hasPrevious())
        	{
        		Node adding = this;
        		Node temp = current.getLinkPrev();
        		this.setLinkNext(current);
        		current.setLinkPrev(adding); //current is updated with new node as previous and same next
        		this.setLinkPrev(temp);
        	}
        	else throw new NoSuchElementException();
        }
        public void addAfter(Node current)
        {
        	if(!current.hasNext()) //if no next node
            {
        		Node adding = this;
            	this.setLinkPrev(current); //new node is set to next of current
            	current.setLinkNext(adding); //current is updated with new node as next
            	return;
            }
        	else if(current.hasNext())
        	{
        		Node adding = this;
        		Node temp = current.getLinkNext();
        		this.setLinkPrev(current); //new node is set to next of current
        		this.setLinkNext(temp); //set new node like to old next
            	current.setLinkNext(adding);  //current is updated with new node as next and same previous
            	return;
        	}
        	else throw new NoSuchElementException();
        }
        
        public boolean equals(Node other)
        {
        	if(this.getLinkNext() != other.getLinkNext())
        		return false;
        	else if(!this.getOrder().equals(other.getOrder()))
        		return false;
        	else if(this.getLinkPrev() != other.getLinkPrev())
        		return false;
        	else
        		return true;
        }
    }
    
    /**
     * @return true if size N is zero
     */
    public boolean isEmpty()
    { 
    	return size == 0; 
    }
    
    /**
     * @return size of linked list
     */
    public int getSize()           
    { 
    	return size;      
    }
    

    /**
	 * @return the start node
	 */
	public Node getStart() {
		return start;
	}

	/**
	 * @param start the start to set
	 */
	public void setStart(Node start) {
		this.start = start;
	}

	/** add the Order to the list
     * @param Order is inserted into list
     */
    public void add(Order Order) 
    {
    	Node current = this.getStart();
        Node x = new Node(Order, null , null);
        if(this.isEmpty()) //no order is yet set
        {
        	System.out.println("setting inital");
        	this.setStart(x);
        }
        else if(this.getSize() == 1)
        {
        	if(current.getOrderPrice() > x.getOrderPrice())
	        {
        		System.out.println("adding after");
	        	x.addAfter(current);
	        }
        	else if(current.getOrderPrice() <= x.getOrderPrice())
	        {
        		System.out.println("adding before");
	        	x.addBefore(current);
	        	this.setStart(x);
	        }
        }
        else
        {   	
	        	while(current.hasNext())
	            {
	        		System.out.println("looping!!");
	        		if(this.getStart().getOrderPrice() <= x.getOrderPrice())
	    	        {
	            		System.out.println("adding before");
	    	        	x.addBefore(this.getStart());
	    	        	this.setStart(x);
	    	        }
	            	if(current.getOrderPrice() > x.getOrderPrice())
	    	        {
	            		if (!current.hasNext())
	            		{
	            			System.out.println("adding last pos");
		    	        	x.addAfter(current);
		    	        	break;
	            		}
	            		else if(current.getLinkNext().getOrderPrice() < x.getOrderPrice())
	            		{
	            			System.out.println("adding after");
		    	        	x.addAfter(current);
		    	        	break;
	            		}
	            		else
	            		{
	            			current = current.getLinkNext();
	            			if(current == null)
	            			{
	            				break;
	            			}
	            			continue;
	            		}
	            			
	            		
	    	        }
	            	else if(current.getOrderPrice() == x.getOrderPrice())
	    	        {
	            		System.out.println("adding before");
	    	        	x.addBefore(current);
	    	        	break;
	    	        }
	            	if(current.getOrderPrice() < x.getOrderPrice())
	    	        {
	            			current = current.getLinkNext();
	            			if(current == null)
	            			{
	            				break;
	            			}
	    	        }
	            }
        	}
        size += 1;
        if(current != null)
        	System.out.println(current.getOrder() + "\n" + Order + "\n");
        	this.matchingEngine();
        return;
    }
    
    public Node getBestBid()
    {
    	System.out.println("\ngetting best bid!");
		Node current = this.getStart();
        while(current.hasNext())
        {
        	if(current.getOrder() instanceof BidOrder)
        	{
        		return current;
        	}
        	current = current.getLinkNext();
        }
        return null;
    }
    
    public Node getBestOffer()
    {
    	System.out.println("\ngetting best offer!");
		Node current = this.getStart().getLinkNext();
		Node bestOffer = this.getStart();
        while(current.hasNext())
        {
        	if(current.getOrder() instanceof BidOrder)
        	{
        		if(bestOffer.getOrderPrice() >= current.getOrderPrice())
        			bestOffer = current;
        	}
        	current = current.getLinkNext();
        }
        return bestOffer;
    }
    
    public void remove(Node delete)
    {
    	Node pre = delete.getLinkPrev();
    	Node aft = delete.getLinkNext();
    	
    	pre.setLinkNext(aft);
    	aft.setLinkPrev(pre);
    }
    
    public void matchingEngine()
    {
    	Node bestBid = this.getBestBid();
    	Node bestOffer = this.getBestOffer();
    	while(bestBid.getOrderPrice() >= bestOffer.getOrderPrice())
    	{
    		int bidVolume = bestBid.getOrder().getVolume();
    		int offerVolume = bestOffer.getOrder().getVolume();
    		if(bidVolume > offerVolume)
    		{
    			int dif = bidVolume - offerVolume;
    			bestBid.getOrder().setVolume(dif);
    			this.remove(bestOffer);
    		}
    		if(bidVolume == offerVolume)
    		{
    			this.remove(bestBid);
    			this.remove(bestOffer);
    		}
    		bestBid = this.getBestBid();
        	bestOffer = this.getBestOffer();
    	}
    }

	@Override
	public void printFullDetails() 
	{
		System.out.println("\nPrinting Book!");
		Node current = this.getStart();
        while(current.hasNext())
        {
        	System.out.println(current.getOrder());
        	current = current.getLinkNext();
        }
        System.out.println(current.getOrder());
	}
}