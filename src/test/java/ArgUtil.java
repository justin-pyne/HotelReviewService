import java.nio.file.FileSystems;

public class ArgUtil {
    private static String arg0 = "-hotels";
    private static String arg2 = "-reviews";

    public static String[] prepareArgsSmallDataset() {
        String arg1 = "dataset" + FileSystems.getDefault().getSeparator() +"hotelsTiny" + FileSystems.getDefault().getSeparator()  + "hotel1.json";
        String arg3 = "dataset" + FileSystems.getDefault().getSeparator() +"reviewsTiny";
        String[] args = {arg0, arg1, arg2, arg3};
        return args;
    }

    public static String[] prepareArgsStandardDataset() {
        //  a larger hotels.json file and larger reviews folder
        String arg1 = "dataset" + FileSystems.getDefault().getSeparator() +"hotels" + FileSystems.getDefault().getSeparator()  + "hotels.json";
        String arg3 = "dataset" + FileSystems.getDefault().getSeparator() +"reviews";
        // System.out.println(arg3);
        String[] args = {arg0, arg1, arg2, arg3};
        return args;
    }
}
