package world.coding.challenges.useful;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CommonJava {

    private static final Map<Character, Integer> NUCLEOTIDE_IMPACT_FACTORS;
    static {
        Map<Character, Integer> map = new HashMap<>();
        map.put('a', 1);
        map.put('b', 2);
        NUCLEOTIDE_IMPACT_FACTORS = Collections.unmodifiableMap(map);
    }

    void conversion(){

        StringBuilder builder = new StringBuilder();
        char c = 'x';
        builder.append(c);

        List<Integer> list = new ArrayList<>();
        int[] ints = list.stream().mapToInt(i -> i).toArray();
    }

    public static double getRandomDoubleBetweenRange(double min, double max){
        return (Math.random()*((max-min)+1))+min;
    }

    public static void main(String[] args) {

        int n = 3;
        int[] dp = {1,4,20};
        int key = 13;
        Arrays.sort(dp,0,n);
        int index = Arrays.binarySearch(dp, 0, n, key); // must be sorted
        List<Integer> l = new LinkedList<>();
        l.add(3);
        l.add(2);
        l.add(1);
        for (Integer i : l){
            System.out.println(i);
        }
        int n1 = 2/2, n2 = 3/2;
        boolean  intIgnoresFractional = n1 == n2;
        int theMax = Math.max(3, 4);

        NUCLEOTIDE_IMPACT_FACTORS.get('a');

        int[] A = new int[3];
        // watch out for subsequent calls - do it just once at the end and on the spot?
        Arrays.fill(A, 1);
        System.out.println(Arrays.toString(A));

        NUCLEOTIDE_IMPACT_FACTORS.get('c');
        "".length();
        //enhanced for
        for (int X : A) {
        }

        String s = "abc";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
        }
        //costly
        for (char ch : "xyz".toCharArray()) {
        }


        // using streams needs import java.util.stream.*;
        Set<Integer> integers = Arrays
            .stream(A)
            //To convert a stream of primitives, you must first box the elements in their wrapper class and then collect them
            .boxed()
            .collect(Collectors.toSet());

        int[] ints = integers.stream().mapToInt(Integer::intValue).toArray();

        Optional<Integer> maxOptional = IntStream.of(A)
            .boxed()
            .max(Integer::compareTo);

        int max = maxOptional.orElse(0);


        Set<Integer> set = new HashSet<Integer>(Arrays.<Integer>asList(1, 2, 3));

        //TreeSet is one of the most important implementations of the SortedSet interface in Java that uses a Tree for storage.
        //Objects in a TreeSet are stored in a sorted and ascending order.
        //TreeSet does not preserve the insertion order of elements but elements are sorted by keys.
        Set<Integer> treeSet = new TreeSet<>(Arrays.<Integer>asList(4, 2, 1));
        System.out.println("TreeSet:" + treeSet);

        TreeSet<Integer> treeSet2 = Stream.of(4, 3, 1, 6).collect(Collectors.toCollection(TreeSet::new));
        System.out.println("TreeSet2:" + treeSet2);

        treeSet.iterator().hasNext();
        treeSet.iterator().next();

        Math.pow(2,3);

        Integer[] objects = treeSet.toArray(new Integer[0]);
        int maxValue = Integer.MAX_VALUE;

//        just cast one of the two operands to a float first.
        int a = 3;
        int b = 2;
        float v = (float)a / b;

        String TIPS =
            "- start with test cases! figure out what should be the output before"+
            "- include edge cases like 0,1, max int"+
            "- pay attention to what should happen to 0 or empty string - positive or negative resp??"+
            "- remember if sorting helps first or not" +
            "- remember -5 * -5 is 25" +
            "- remember int 2/2 is same as 3/2" +
            "- remember mixing index with length, subtract from size when assigning to index and viceversa"+
            "- consider MAX_INT especially for sums => use (float) cast when needed" +
            "- dominator (occurences>n/2) can be found at the middle of a sorted array" +
            "- test with big int numbers too (1b) (test with brute force for correct result if allowed)";

        String PERFORMANCE =
            "- leader -> sort and pick the candidate from the middle (n/2) then count it's occurences to see if it happens more often than n/2" +
                " watch out for successive operations, do it only the last time and as needed" +
                "- prefix sums - fast calculation of sums of elements in given slice (contiguous segments of array)" +
                "   P[k] = P[k-1]+a[k-1]   where p0=0, p1=a0 etc." +
                "   total for slice [x,y] is P[Y+1] - P[X]" +
                "- watch out for input transformation to matrix - ex. how a type with a priority become a vector where the index meant the priority" +
                "       going left to right could just stop because lowest priority was found";

//        The right way to remove objects from ArrayList while iterating over it is by using the Iterator's remove()
        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(1);
        arrayList.add(2);


        Collections.reverse(arrayList);

        arrayList.set(0,11);

        arrayList.removeIf(loan -> loan.equals("personal loan"));

        Iterator<Integer> itr = arrayList.iterator();
        int x = 0;
        while (itr.hasNext()) {

            Integer loan = itr.next();
            x = loan;
            if (loan.equals("personal loan")) {
                itr.remove();
            }
        }


//        java strings are immutable - if you plan to keep appending to the string, then better use StringBuilder.
        String str = new String("optional initialization"); // declares an empty string. O(1)
        // for mutable string :
        StringBuilder stringBuilder = new StringBuilder("optional initialization"); // empty string
        stringBuilder.charAt(0);     // O(1). Works for both String and StringBuilder
        stringBuilder.length();  // O(1) operation
        str.concat("Hello"); // O(n) operation. Creates another copy of the string as string is immutable.
        stringBuilder.append("Hello"); // O(l) operation where l is the length of the string being appended. Much more efficient.

        stringBuilder.append("b").append("a").reverse().toString();

        min();
        sorting();
        queue();
        heap();
        stacks();
        power();
    }

    /**
     * Prefix sums are trivial to compute in sequential models of computation,
     * by using the formula yi = yi − 1 + xi to compute each output value in sequence order.
     * <p>
     * However, despite their ease of computation, prefix sums are a useful primitive in certain algorithms such as counting sort
     * and they form the basis of the scan higher-order function in functional programming languages.
     * <p>
     * Prefix sums have also been much studied in parallel algorithms,
     * both as a test problem to be solved and as a useful primitive to be used as a subroutine in other parallel algorithms.
     * <p>
     * https://en.wikipedia.org/wiki/Prefix_sum
     */
    class PrefixSums {
        int[] prefixSum(int[] input) {
            int[] prefixSum = new int[input.length + 1];
            for (int i = 1; i < input.length + 1; i++) {
                prefixSum[i] = prefixSum[i - 1] + input[i - 1];
            }
            return prefixSum;
        }

        int countTotal(int[] prefixSum, int x, int y) {
            return prefixSum[y + 1] - prefixSum[x];
        }
    }

    /**
     * A Red-Black tree based NavigableMap implementation
     *
     * Both TreeMap and TreeSet are slower than there Hash counter part like HashSet and HashMap
     * and instead of providing constant time performance for add, remove and get operation
     * they provide performance in O(log(n)) order.
     *
     *  TreeSet stores only one object while TreeMap uses two objects called key and Value.
     *  Objects in TreeSet are sorted while keys in TreeMap remain in sorted Order.
     */
    static void treeMap(){
        TreeMap<Integer, Integer> A = new TreeMap<Integer, Integer>(); // O(1) declaration which declares an empty tree map.
        int K=0,V=0, x=0;
        A.put(K, V);// O(log n)
        A.remove(K); // O(log n)
        A.containsKey(K);  // O(log n)
        A.get(K);     // O(log n)
        //minimum key
        A.firstKey(); //O(1)
        A.firstEntry().getKey();     // O(1)
//        maximum key K in the map
        A.lastKey();
        A.lastEntry().getKey();
        for (Map.Entry<Integer, Integer> entry : A.entrySet()) {
            // entry.getKey() has the key, entry.getValue() has the value
        }
//        Find closest key K >= x :
        A.ceilingEntry(x).getKey();     // O(log n). Do need to handle the case when x is more than the max key in the map.
        A.floorEntry(x).getKey();     // O(log n). Do need to handle the case when x is smaller than min key in the map
        A.size();
    }


    /**
     * Binary search obviously works on searching for elements in a sorted array.
     * The reason why it works is because the array itself is monotonic ( either increasing or decreasing )
     *
     *  Similar thing can be done with monotonic functions ( monotonically increasing or decreasing ) as well.
     * Lets say we have f(x) which increases when x increases.
     *
     * So, given a problem of finding x so that f(x) = p, I can do a binary search for x.
     *
     * At any instance,
     * 1. if f(current_position) > p, then I will search for values lower than current_position.
     * 2. if f(current_position) < p, then I will search for values higher than current_position
     * 3. if f(current_position) = p, then I have found my answer.
     */
    int binarySearch(int Arr[], int n, int target) {

        //set stating and ending index
        int start = 0, ending = n-1;

        while(start <= ending) {
            // take mid of the list
            int mid = (start + ending) / 2;

            // we found a match
            if(Arr[mid] == target) {
                return mid;
            }
            // go on right side
            else if(Arr[mid] < target) {
                start = mid + 1;
            }
            // go on left side
            else {
                ending = mid - 1;
            }
        }
        // element is not present in list
        return -1;
    }

    static void stacks(){
        Stack<Character> stack1 = new Stack<>();
        stack1.push('c');
        stack1.push('c');
        stack1.pop();
        stack1.peek();
        Optional.empty();
        boolean hasItems = !stack1.empty();

        Deque<Integer> stack = new ArrayDeque<>();
        //push
        stack.addFirst(5);
        //pop
        stack.removeFirst();
        //peek - nullable
        Integer integer = stack.peekFirst();

        stack.size();
    }

    static void heap(){
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();



        Queue<Integer> maxHeap3 = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> maxHeap2 = new PriorityQueue<>((Integer o1, Integer o2) -> (- Integer.compare(o1,o2)));

        maxHeap2.add(1); //add element to the queue. O(log n)
        maxHeap2.add(10);
        maxHeap2.add(5);
        Integer removed = maxHeap2.remove();//get and remove the min/max. O(log n)
        maxHeap2.peek();//to get, but not remove the min/max. O(1)

        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return - Integer.compare(o1,o2);
            }
        });

    }
    static void queue(){

//        ArrayDeque is Resizable-array implementation of the Deque interface.
//        Array deques have no capacity restrictions; they grow as necessary to support usage
//        Null elements are prohibited.
//        ArrayDeque is likely to be faster than Stack when used as a stack,
//        and faster than LinkedList when used as a queue.
        Deque<Integer> queue = new ArrayDeque<>();
        queue.addLast(4);queue.addLast(4);

        //add
        queue.addLast(4);

        //offer
        queue.offerLast(5);
        //remove
        queue.removeFirst();
        //poll
        queue.pollFirst();
        //element
        queue.getFirst();
        //peek
        queue.peekFirst();
        //LinkedList supports null elements, whereas ArrayDeque does not

        queue.size();

//        A LinkedList is already a queue, since it implements the Queue interface
//     suitable when we don't know the size of data which we are going to use
//        LinkedList supports null elements, whereas ArrayDeque does not
//        Linked structures are possibly the worst structure to iterate with a cache miss on each element
//        If you need add/remove of the both ends,
//        ArrayDeque is significantly better than a linked list. Random access each element is also O(1) for a cyclic queue.

        LinkedList<String> queue1 = new LinkedList<>();
        queue1.add("1");//Appends the specified element to the end of this list
        queue1.remove(); // Retrieves and removes the head (first element) of this list.
        queue1.poll();
        queue1.peek();

    }

    static void min(){
        char[] a = {'3', '5', '1', '4', '2'};

        List b = Arrays.asList(a);

        System.out.println(Collections.min(b));
        System.out.println(Collections.max(b));

        int[] tab = {12, 1, 21, 8};
        int min = Arrays.stream(tab).min().getAsInt();
        int max = Arrays.stream(tab).max().getAsInt();

        IntSummaryStatistics stat = Arrays.stream(tab).summaryStatistics();
        int min2 = stat.getMin();
        int max2 = stat.getMax();

        System.out.println("Min = " + min);
        System.out.println("Max = " + max);
    }

    static void power(){
        int n = 30; //int can do 31 then go for long for 63

//        A << x is  equal to multiplication by pow(2, x)
//         1 << x is equal to pow(2, x).
        boolean valid =  Math.pow(2, n) == 1<<n;
        if (!valid){throw new RuntimeException();}
//        If this is a left shift, then we need to multiply the number by 2 to power n and for right shift we have to divide the number by 2 to power n
//        A >> x is equal to division by pow(2, x)
    }

    static void sorting(){
        int[] arr = {10,3,-3,1};
        Arrays.sort(arr);
        List<String> list = new ArrayList<>();
        list.add("x");// O(1)
        list.addAll(new ArrayList<>());
        list.add("a");
        list.set(1, "newValue");  // O(1)
        list.size();  // O(1) operation
        list.add("newValue"); // appends to the end of the list. O(1) operation.
        list.add(2, "newValue"); // add the value at specified index. O(size - index) operation.

//        All elements in the list must implement the {@link Comparable} interface
        Collections.sort(list);// works for objects Collections like ArrayList, LinkedList, etc.
        list.sort(null);
        Comparator<String> byName =
            (String o1, String o2)->o1.compareTo(o2);
        Comparator<String> byNameShort = String::compareTo;
        list.sort(byName);
    }

    static void copyArray(){

        //shallow copy - we only copy values of fields
        // if the objects were immutable we wouldn't bother

        //for primitives - clone  (unless objects properly implement clone)
        // avoid clone - is very tricky to implement correctly in all circumstances
        //copy constructors and static factory methods provide an alternative to clone
        //http://www.javapractices.com/topic/TopicAction.do?Id=71
        int[] a = {1,2,3};
        int[] b = a.clone();

        int[] array = {23, 43, 55, 12};
        int newLength = array.length;
        int[] copiedArray = Arrays.copyOf(array, newLength);

        int[] copiedArrayRange = Arrays.copyOfRange(array, 1, 4);

        String[] strArray = new String[]{""};
        //shallow copy
        String[] strArrayCopy = Arrays.stream(strArray).toArray(String[]::new);

        //deep copy

        //copy constructor
//        public User(User that) {
//            this(that.getFirstName(), that.getLastName(), new Address(that.getAddress()));
//        }

        //serialise & deserialise
    }

    static void hashing(){
//        if we have a list of 10,000 words of English and we want to check if a given word is in the list,
//        it would be inefficient to successively compare the word with all 10,000 items until we find a match.
//
//        Hashing is a technique to make things more efficient by effectively narrowing down the search at the outset.

//        Hashing means using some function or algorithm to map object data to some representative integer value.
            //map data of arbitrary size to fixed-size values

//        The values are used to index a fixed-size table called a hash table
//         hash table or, Hashmap in Java

    //        Buckets
        //Now, we can solve the problem of collisions by having an array of (references to) linked lists rather than simply an array of keys/values. Each little list is generally called a bucket.

    }
    int MAX_SIZE = 10;
    private int hashCode(String s) {
        int hash = 0;
        for (int i = 0; i < s.length(); i++) {
            hash = hash * 31 + s.charAt(i);
        }
        return hash % MAX_SIZE;
    }


    void matrix(){
        int n =0;
        int memo[][] = new int[n + 1][n];
        for (int[] l : memo) {
            Arrays.fill(l, -1);
        }
    }
    void cursor(){
//        Iterator vs ListIterator
//        - both being cursor, Iterator traverses elements only forwards
//        - On the other hand, the ListIterator can traverse in both forward and backward directions.
//            Using iterator you can not add any element to a collection. But, by using ListIterator you can add elements to a collection.
//            Using Iterator, you can not remove an element in a collection where, as You can remove an element from a collection using ListIterator.
//        Using Iterator you can traverse all collections like Map, List, Set. But, by ListIteror you can traverse List implemented objects only.
//        You can retrieve an index of an element using Iterator. But as List is sequential and index-based you can retrieve an index of an element in using ListIterator.
    }

}
