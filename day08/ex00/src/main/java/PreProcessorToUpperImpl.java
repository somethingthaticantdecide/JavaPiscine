public class PreProcessorToUpperImpl implements PreProcessor{
    @Override
    public void print(String text) {
        System.out.println(text.toUpperCase());
    }
}
