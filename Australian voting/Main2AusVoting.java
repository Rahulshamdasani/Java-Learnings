package Ass1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main2AusVoting {
    public static void main (String [] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int totalCases=Integer.parseInt(br.readLine());
        br.readLine();
        for (int Case=0;Case<totalCases;Case++) {
            int politicians=Integer.parseInt(br.readLine());
            String [] name=new String[politicians];
            for (int n=0;n<politicians;n++) {
                name[n] = br.readLine();
            }
            String s;
            ArrayList<ArrayList<Integer>> votes=new ArrayList<>();
            while (true) {
                s=br.readLine();
                if (s==null || s.equals("")) break;

                StringTokenizer tokenizer=new StringTokenizer(s);
                ArrayList<Integer> row=new ArrayList<>();
                votes.add(row);
                for (int n=0;n<politicians;n++) row.add(Integer.parseInt(tokenizer.nextToken())-1);
            }

            String solution="";
            boolean [] elimList=new boolean [politicians];
            for (int i=0;i<politicians;i++) {
                int [] voteCount=new int [politicians];
                for (ArrayList<Integer> v : votes) voteCount[v.get(i)]++;

                int minVotes=Integer.MAX_VALUE, maxVotes=0;
                for (int currPolitician=0;currPolitician<politicians;currPolitician++) if (!elimList[currPolitician]) {
                    minVotes=Math.min(minVotes, voteCount[currPolitician]);
                    maxVotes=Math.max(maxVotes, voteCount[currPolitician]);
                }

                if (minVotes==maxVotes) {
                    StringBuilder sb=new StringBuilder();
                    for (int currPolitician=0;currPolitician<politicians;currPolitician++) if (!elimList[currPolitician]) {
                        sb.append(name[currPolitician]);
                        sb.append('\n');
                    }
                    sb.setLength(sb.length()-1);
                    solution=sb.toString();
                    break;
                } else {
                    for (int currPolitician=0;currPolitician<politicians;currPolitician++) if (!elimList[currPolitician] && voteCount[currPolitician]==minVotes) {
                        elimList[currPolitician]=true;
                        for (ArrayList<Integer> v : votes) v.remove(Integer.valueOf(currPolitician));
                    }
                    i--;
                }
            }

            if (Case>0) System.out.println();
            System.out.println(solution);
        }
    }

}
