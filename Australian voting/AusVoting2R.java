package Ass1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class AusVoting2R {


        static int num, n_testcases;
        static HashMap<String,ArrayList<ArrayList>> roundhash = new HashMap<>();
        static ArrayList<ArrayList> votes = new ArrayList<ArrayList>();  // Declaring list of charArray
        static List<String> inputList = new ArrayList<String>();
        static ArrayList names = new ArrayList();
        static Set<String> eliminated = new HashSet<>();
        static  ArrayList solution = new ArrayList();


        public static void sortAndPrint(){
            for(int i = 0;i<names.size();i++){
                String currName = (String) names.get(i);
                if(solution.contains(currName)){
                    System.out.println(currName);
                }
            }
        }

        public static void readFile() throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String st;


            n_testcases = Integer.parseInt(br.readLine());

            br.readLine();


            for (int i=0; i<=n_testcases; i++){
                inputList.clear();
                names.clear();roundhash.clear();
                votes.clear();
                eliminated.clear();
                solution.clear();
                String prev = "";

                while((st = br.readLine())!=null){

                    if(st.trim().equals("") || prev == st){
                        helper();

                        sortAndPrint();

                        break;

                    }
                    if(st == null || st == prev){

                        System.out.println(inputList);
                        helper();
                        prev = st;
                    }
                    inputList.add(st);


                }
            }

        }

        public static void getNames (){
            num = Integer.parseInt(inputList.get(0));
            for(int i = 0; i <num; i++){
                names.add(inputList.get(i+1));
            }
            for(int i = 0; i <num; i++){
                roundhash.put((String) names.get(i), new ArrayList<>());

            }

        }

        public static void getVotes(){

            for(int i = num+1;i<inputList.size();i++){
                ArrayList<Integer> charsNum = new ArrayList<>();
                String t = inputList.get(i);
                String[] s = t.split("\\s+");
                for (String ch : s) { charsNum.add(Integer.parseInt(ch));}
                votes.add(charsNum);
            }
        }

        public static int getMinVoter(){
            String minName = null;
            int minVotes = Integer.MAX_VALUE;

            for (Map.Entry mapElement : roundhash.entrySet()) {
                ArrayList val = (ArrayList) mapElement.getValue();
                ArrayList temp = new ArrayList<>();
                temp = (ArrayList) mapElement.getValue();
                if(temp.size() < minVotes){
                    minVotes = temp.size();
                    minName = (String) mapElement.getKey();
                }
            }


            return minVotes;
        }

        public static String getWinner() {
            int minVotes = Integer.MAX_VALUE;
            int maxVotes = 0;
            for (Map.Entry mapElement : roundhash.entrySet()) {
                String key = (String) mapElement.getKey();
                ArrayList v = roundhash.get(key);
                int val = v.size();
                if (val < minVotes) {
                    minVotes = val;
                }
                if (val > maxVotes) {
                    maxVotes = val;
                }


            }
            if (minVotes == maxVotes) {
                return "Winner";
            }
            return "No Winner";
        }

        public static String isvalid(ArrayList temp){

            for(int i = 0; i < temp.size(); i++){
                String name = inputList.get(Integer.parseInt(String.valueOf(temp.get(i))));
                if(!eliminated.contains(name)){
                    return name;
                }

            }
            return "";
        }

        public static void getVoteCount(){

            for (Map.Entry mapElement : roundhash.entrySet()) {
                String key = (String) mapElement.getKey();
                ArrayList v = roundhash.get(key);
                System.out.println(key+" got "+v.size()+" votes");
            }
        }

        public static ArrayList getNewVotes(int minVotes){

            ArrayList votes = new ArrayList();
            ArrayList removeThese = new ArrayList();
            for (Map.Entry mapElement : roundhash.entrySet()) {
                ArrayList temp = roundhash.get(mapElement.getKey());

                if(temp.size() <= minVotes){
                    String name = (String) mapElement.getKey();

                    votes.addAll(temp);
                    removeThese.add(name);
                    eliminated.add(name);
                }


            }

            for(int i = 0; i<removeThese.size();i++){
                roundhash.remove(removeThese.get(i));
            }


            return votes;

        }


        public static void helper(){
            getNames();
            getVotes();
            for(int round = 0; round<=names.size();round++) {
                if(round > 1){

                    int minVotes = getMinVoter();
                    votes = getNewVotes(minVotes);


                }

                for (int i = 0; i < votes.size(); i++) {
                    ArrayList<Character> temp = new ArrayList<Character>();
                    temp = votes.get(i);
                    String name = isvalid(temp);
                    roundhash.get(name).add(temp);



                }
                if(getWinner() == "Winner"){
                    for ( String key : roundhash.keySet() ) {
                        solution.add(key);


                    }
                    System.out.println();
                    break;
                }



            }
        }

        public static void main(String[] args) throws Exception {
            readFile();

        }


    }

