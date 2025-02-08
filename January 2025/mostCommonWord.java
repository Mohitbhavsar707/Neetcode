class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.toLowerCase().replaceAll("[^a-z]", " ");

        String [] words = paragraph.split("\\s+");

        String mostCommon = "";
        int maxCount = 0;


        for(int i = 0; i < words.length; i++){
            if(isBanned(words[i], banned) || words[i].isEmpty()) continue;
            int count = 0;
            for(int j = 0; j < words.length; j++){
                if(words[i].equals(words[j])){
                    count++;
                }
            }
            if( count > maxCount) {
                 mostCommon = words[i];
                 maxCount = count;
            }
        }
        return mostCommon;
        
        
    }

    private boolean isBanned(String word, String[] banned){
        for(String b : banned){
            if(word.equals(b)){
                return true;
            }
        }
        return false;
    }
}