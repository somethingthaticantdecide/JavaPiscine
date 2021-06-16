public class PreProcessorToLower implements PreProcessor{
    @Override
    public void print(String text) {
        System.out.println(text.toLowerCase());
    }
}
