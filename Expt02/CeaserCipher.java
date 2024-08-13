public class CaesarCipher {
    private int shift;

    public CaesarCipher(int shift) {
        this.shift = shift;
    }

    public String encrypt(String text) {
        return shiftText(text, shift);
    }

    public String decrypt(String text) {
        return shiftText(text, -shift);
    }

    private String shiftText(String text, int shift) {
        StringBuilder result = new StringBuilder();
        shift = shift % 26 + 26; // Ensure shift is within the range of 0-25

        for (char i : text.toCharArray()) {
            if (Character.isLetter(i)) {
                char base = Character.isLowerCase(i) ? 'a' : 'A';
                // Perform the shift operation
                char shifted = (char) ((i - base + shift) % 26 + base);
                result.append(shifted);
            } else {
                result.append(i); // Non-alphabet characters are added unchanged
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        CaesarCipher cipher = new CaesarCipher(3); // Example shift of 3

        String originalText = "Hello, World!";
        String encryptedText = cipher.encrypt(originalText);
        String decryptedText = cipher.decrypt(encryptedText);

        System.out.println("Original Text: " + originalText);
        System.out.println("Encrypted Text: " + encryptedText);
        System.out.println("Decrypted Text: " + decryptedText);
    }
}
