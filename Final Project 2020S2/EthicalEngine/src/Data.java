/**
 * 
 */
public class Data {
    private String string;
    private int countAll;
    private int countSur;

    /**
     * constructor
     * @param string
     * @param countAll
     */
    public Data(String string, int countAll){
        this.string = string;
        this.countAll = countAll;
    }

    /**
     * constructor
     * @param string
     * @param countAll
     * @param countSur
     */
    public Data(String string, int countAll, int countSur){
        this.string = string;
        this.countAll = countAll;
        this.countSur = countSur;
    }

    /**
     * copy constructor
     * @param otherData
     */
    public Data(Data otherData){
        this.string = otherData.string;
        this.countAll = otherData.countAll;
        this.countSur = otherData.countSur;
    }

    /**
     * compare two datas
     * @param otherData
     * @return ture(means exchange the position), false(not change)
     */
    public boolean Compare(Data otherData){
        double ratio1 = (double) countSur/ countAll;
        double ratio2 = (double) otherData.countSur/otherData.countAll;
        if(ratio1 > ratio2){
            return true;
        }else if(ratio1 == ratio2){
            if(this.string.compareTo(otherData.string) < 0){
                return true;
            }
        }
        return false;
    }

    /**
     * Get string
     * @return string
     */
    public String getString() {
        return string;
    }

    /**
     * set string
     * @param string
     */
    public void setString(String string) {
        this.string = string;
    }

    /**
     * get countall
     * @return countall
     */
    public int getCountAll() {
        return countAll;
    }

    /**
     * set countall
     * @param countAll
     */
    public void setCountAll(int countAll) {
        this.countAll = countAll;
    }

    /**
     * get count survival
     * @return
     */
    public int getCountSur() {
        return countSur;
    }

    /**
     * set count survival
     * @param countSur
     */
    public void setCountSur(int countSur) {
        this.countSur = countSur;
    }

    /**
     * get tostring
     * @return statistic string
     */
    public String toString(){
        double ratio = (double)countSur / countAll;
        double ratioRound = Math.ceil(ratio * 100) / 100.0;
        return string + ": " + String.format("%.2f", ratioRound) + "\n";
    }
}
