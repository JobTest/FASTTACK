package com.cts.fasttack.common.core.util;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.MalformedJsonException;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Anton Leliuk
 */
public class StringUtil {

    private static final String MASKED_STRING = "******";

    /**
     * Pan display - 666666_4444. Characters number that will be displayed in the begin of pan or token (666666).
     */
    public static final int FIRST_PAN_SYMBOLS_TO_DISPLAY = 6;

    /**
     * Pan display - 666666_4444. Characters number that will be displayed in the end of pan or token.(4444).
     */
    public static final int LAST_PAN_SYMBOLS_TO_DISPLAY = 4;

    /**
     * Map with sensitive fields, which should hide from log
     * Key its a pattern for find such sensitive field in json
     * Value its a replacement string
     */
    private static final Map<Pattern, String> JSON_SENSITIVE_FIELDS = new HashMap<>(18);

    private static final Set<String> XML_SENSITIVE_FIELD_NAMES = new HashSet<>(17);

    private static final Set<Pattern> XML_SENSITIVE_FIELD_PATTERNS = new HashSet<>(17);

    private static final Set<String> EXCEPTION_REPLACES = new HashSet<>();

    static {
        JSON_SENSITIVE_FIELDS.put(Pattern.compile("(\"password\"\\s*:+\\s*\".*?\")+"), "\"password\":\"" + MASKED_STRING + "\"");
        JSON_SENSITIVE_FIELDS.put(Pattern.compile("(\"Password\"\\s*:+\\s*\".*?\")+"), "\"Password\":\"" + MASKED_STRING + "\"");
        JSON_SENSITIVE_FIELDS.put(Pattern.compile("(\"ActivationCode\"\\s*:+\\s*\".*?\")+"), "\"ActivationCode\":\"" + MASKED_STRING + "\"");
        JSON_SENSITIVE_FIELDS.put(Pattern.compile("(\"activationCode\"\\s*:+\\s*\".*?\")+"), "\"activationCode\":\"" + MASKED_STRING + "\"");
        JSON_SENSITIVE_FIELDS.put(Pattern.compile("(\"otp\"\\s*:+\\s*\".*?\")+"), "\"otp\":\"" + MASKED_STRING + "\"");
        JSON_SENSITIVE_FIELDS.put(Pattern.compile("(\"Code\"\\s*:+\\s*\".*?\")+"), "\"Code\":\"" + MASKED_STRING + "\"");
        JSON_SENSITIVE_FIELDS.put(Pattern.compile("(\"mobilePin\"\\s*:+\\s*\".*?\")+"), "\"mobilePin\":\"" + MASKED_STRING + "\"");
        JSON_SENSITIVE_FIELDS.put(Pattern.compile("(\"MobilPin\"\\s*:+\\s*\".*?\")+"), "\"MobilPin\":\"" + MASKED_STRING + "\"");
        JSON_SENSITIVE_FIELDS.put(Pattern.compile("(\"cardNumber\"\\s*:+\\s*\".*?\")+"), "\"cardNumber\":\"" + MASKED_STRING + "\"");
        JSON_SENSITIVE_FIELDS.put(Pattern.compile("(\"cardNum\"\\s*:+\\s*\".*?\")+"), "\"cardNum\":\"" + MASKED_STRING + "\"");
        JSON_SENSITIVE_FIELDS.put(Pattern.compile("(\"cardNum\"\\s*:+\\s*\\d+)+"), "\"cardNum\":\"" + MASKED_STRING + "\"");
        JSON_SENSITIVE_FIELDS.put(Pattern.compile("(\"pan\"\\s*:+\\s*\".*?\")+"), "\"pan\":\"" + MASKED_STRING + "\"");
        JSON_SENSITIVE_FIELDS.put(Pattern.compile("(\"PAN\"\\s*:+\\s*\".*?\")+"), "\"PAN\":\"" + MASKED_STRING + "\"");
        JSON_SENSITIVE_FIELDS.put(Pattern.compile("(\"token\"\\s*:+\\s*\".*?\")+"), "\"token\":\"" + MASKED_STRING + "\"");
        JSON_SENSITIVE_FIELDS.put(Pattern.compile("(\"CVV2\"\\s*:+\\s*\".*?\")+"), "\"CVV2\":\"" + MASKED_STRING + "\"");
        JSON_SENSITIVE_FIELDS.put(Pattern.compile("(\"CVC\"\\s*:+\\s*\".*?\")+"), "\"CVC\":\"" + MASKED_STRING + "\"");
        JSON_SENSITIVE_FIELDS.put(Pattern.compile("(\"cvnum\"\\s*:+\\s*\".*?\")+"), "\"cvnum\":\"" + MASKED_STRING + "\"");
        JSON_SENSITIVE_FIELDS.put(Pattern.compile("(\"Passcode\"\\s*:+\\s*\".*?\")+"), "\"Passcode\":\"" + MASKED_STRING + "\"");
        JSON_SENSITIVE_FIELDS.put(Pattern.compile("(\"OTP\"\\s*:+\\s*\".*?\")+"), "\"OTP\":\"" + MASKED_STRING + "\"");
        JSON_SENSITIVE_FIELDS.put(Pattern.compile("(\"OTPCode\"\\s*:+\\s*\".*?\")+"), "\"OTPCode\":\"" + MASKED_STRING + "\"");
        JSON_SENSITIVE_FIELDS.put(Pattern.compile("(\"newAccountPan\"\\s*:+\\s*\".*?\")+"), "\"newAccountPan\":\"" + MASKED_STRING + "\"");
        JSON_SENSITIVE_FIELDS.put(Pattern.compile("(\"oldAccountPan\"\\s*:+\\s*\".*?\")+"), "\"oldAccountPan\":\"" + MASKED_STRING + "\"");
        JSON_SENSITIVE_FIELDS.put(Pattern.compile("(\"AccountPan\"\\s*:+\\s*\".*?\")+"), "\"AccountPan\":\"" + MASKED_STRING + "\"");
        JSON_SENSITIVE_FIELDS.put(Pattern.compile("(\"expiryMonth\"\\s*:+\\s*\".*?\")+"), "\"expiryMonth\":\"" + MASKED_STRING + "\"");
        JSON_SENSITIVE_FIELDS.put(Pattern.compile("(\"expiryYear\"\\s*:+\\s*\".*?\")+"), "\"expiryYear\":\"" + MASKED_STRING + "\"");

        XML_SENSITIVE_FIELD_NAMES.add("PassPhrase");
        XML_SENSITIVE_FIELD_NAMES.add("WSPPASSPHRASE");
        XML_SENSITIVE_FIELD_NAMES.add("MobilePIN");
        XML_SENSITIVE_FIELD_NAMES.add("PAN");
        XML_SENSITIVE_FIELD_NAMES.add("pan");
        XML_SENSITIVE_FIELD_NAMES.add("CVV2");
        XML_SENSITIVE_FIELD_NAMES.add("CVC");
        XML_SENSITIVE_FIELD_NAMES.add("Passcode");
        XML_SENSITIVE_FIELD_NAMES.add("OTP");
        XML_SENSITIVE_FIELD_NAMES.add("CardNum");
        XML_SENSITIVE_FIELD_NAMES.add("cardNum");
        XML_SENSITIVE_FIELD_NAMES.add("CVNum");
        XML_SENSITIVE_FIELD_NAMES.add("MerchantID");
        XML_SENSITIVE_FIELD_NAMES.add("TerminalID");
        XML_SENSITIVE_FIELD_NAMES.add("NewAccountPan");
        XML_SENSITIVE_FIELD_NAMES.add("CurrentAccountPan");
        XML_SENSITIVE_FIELD_NAMES.add("AccountPan");
        XML_SENSITIVE_FIELD_NAMES.add("Token");
        XML_SENSITIVE_FIELD_NAMES.add("token");
        XML_SENSITIVE_FIELD_NAMES.add("expiryMonth");
        XML_SENSITIVE_FIELD_NAMES.add("expiryYear");
        XML_SENSITIVE_FIELD_NAMES.add("password");
        XML_SENSITIVE_FIELD_NAMES.add("Password");

        XML_SENSITIVE_FIELD_PATTERNS.add(Pattern.compile("<.*(PassPhrase)\\b\\s*.*>.*", Pattern.CASE_INSENSITIVE));
        XML_SENSITIVE_FIELD_PATTERNS.add(Pattern.compile("<.*(WSPPASSPHRASE)\\b\\s*.*>.*", Pattern.CASE_INSENSITIVE));
        XML_SENSITIVE_FIELD_PATTERNS.add(Pattern.compile("<.*(MobilePIN)\\b\\s*.*>.*", Pattern.CASE_INSENSITIVE));
        XML_SENSITIVE_FIELD_PATTERNS.add(Pattern.compile("<.*(pan)\\b\\s*.*>.*", Pattern.CASE_INSENSITIVE));
        XML_SENSITIVE_FIELD_PATTERNS.add(Pattern.compile("<.*(CVV2)\\b\\s*.*>.*", Pattern.CASE_INSENSITIVE));
        XML_SENSITIVE_FIELD_PATTERNS.add(Pattern.compile("<.*(CVC)\\b\\s*.*>.*", Pattern.CASE_INSENSITIVE));
        XML_SENSITIVE_FIELD_PATTERNS.add(Pattern.compile("<.*(cvnum)\\b\\s*.*>.*", Pattern.CASE_INSENSITIVE));
        XML_SENSITIVE_FIELD_PATTERNS.add(Pattern.compile("<.*(Passcode)\\b\\s*.*>.*", Pattern.CASE_INSENSITIVE));
        XML_SENSITIVE_FIELD_PATTERNS.add(Pattern.compile("<.*(OTP)\\b\\s*.*>.*", Pattern.CASE_INSENSITIVE));
        XML_SENSITIVE_FIELD_PATTERNS.add(Pattern.compile("<.*(cardnum)\\b\\s*.*>.*", Pattern.CASE_INSENSITIVE));
        XML_SENSITIVE_FIELD_PATTERNS.add(Pattern.compile("<.*(CVNum)\\b\\s*.*>.*", Pattern.CASE_INSENSITIVE));
        XML_SENSITIVE_FIELD_PATTERNS.add(Pattern.compile("<.*(MerchantID)\\b\\s*.*>.*", Pattern.CASE_INSENSITIVE));
        XML_SENSITIVE_FIELD_PATTERNS.add(Pattern.compile("<.*(TerminalID)\\b\\s*.*>.*", Pattern.CASE_INSENSITIVE));
        XML_SENSITIVE_FIELD_PATTERNS.add(Pattern.compile("<.*(NewAccountPan)\\b\\s*.*>.*", Pattern.CASE_INSENSITIVE));
        XML_SENSITIVE_FIELD_PATTERNS.add(Pattern.compile("<.*(CurrentAccountPan)\\b\\s*.*>.*", Pattern.CASE_INSENSITIVE));
        XML_SENSITIVE_FIELD_PATTERNS.add(Pattern.compile("<.*(AccountPan)\\b\\s*.*>.*", Pattern.CASE_INSENSITIVE));
        XML_SENSITIVE_FIELD_PATTERNS.add(Pattern.compile("<.*(token)\\b\\s*.*>.*", Pattern.CASE_INSENSITIVE));
        XML_SENSITIVE_FIELD_PATTERNS.add(Pattern.compile("<.*(expiryMonth)\\b\\s*.*>.*", Pattern.CASE_INSENSITIVE));
        XML_SENSITIVE_FIELD_PATTERNS.add(Pattern.compile("<.*(expiryYear)\\b\\s*.*>.*", Pattern.CASE_INSENSITIVE));
        XML_SENSITIVE_FIELD_PATTERNS.add(Pattern.compile("<.*(password)\\b\\s*.*>.*", Pattern.CASE_INSENSITIVE));
        XML_SENSITIVE_FIELD_PATTERNS.add(Pattern.compile("<.*(Password)\\b\\s*.*>.*", Pattern.CASE_INSENSITIVE));

        EXCEPTION_REPLACES.add("pan");
        EXCEPTION_REPLACES.add("PAN");
        EXCEPTION_REPLACES.add("AccountPan");
        EXCEPTION_REPLACES.add("cardNum");
        EXCEPTION_REPLACES.add("CardNum");
        EXCEPTION_REPLACES.add("cardNumber");
    }


    private static final Charset UTF_8 = StandardCharsets.UTF_8;

    /**
     * Append symbol as byte to source bytes
     *
     * @param source                   source bytes
     * @param length                   length which will be result of bytes array
     * @param symbol                   symbol
     * @param isSymbolsSequenceLeading symbol leading, if true then will be at start, if false then at end
     * @return bytes
     */
    public static byte[] appendSymbolSequenceToBytes(byte[] source, int length, char symbol, boolean isSymbolsSequenceLeading) {
        byte[] result = {};
        if (!isSymbolsSequenceLeading) {
            result = ArrayUtils.addAll(result, source);
        }
        while (result.length < length - source.length) {
            result = ArrayUtils.add(result, (byte) symbol);
        }
        if (isSymbolsSequenceLeading) {
            result = ArrayUtils.addAll(result, source);
        }
        return result;
    }

    public static <T extends Enum<T>> T parseEnum(Class<T> enumType, String value) {
        T[] enums = enumType.getEnumConstants();
        for (T enumeration : enums) {
            if (enumeration.name().equals(value)) {
                return enumeration;
            }
        }
        return null;
    }

    /**
     * Hide sensitive fields from json payload
     *
     * @return string with masked fields
     */
    public static String sensitiveFieldsHiding(String payload) {
        final String[] finalPayload = {payload};
        JSON_SENSITIVE_FIELDS.forEach((k, v) -> finalPayload[0] = replace(finalPayload[0], k, v));
        return finalPayload[0];
    }

    /**
     * Hide sensitive value inside xml tags
     *
     * @param payload original data
     * @return string with masked fields
     */
    public static String sensitiveFieldsFromXmlHiding(String payload) {
        if(XML_SENSITIVE_FIELD_NAMES.stream().noneMatch(payload::contains)){
            return payload;
        }
        String[] parts = payload.split("</");
        for (String part : parts) {
            if(part.indexOf(">") != part.length() - 1){
                int lastIndexOf = part.lastIndexOf("<");
                if(lastIndexOf > -1){
                    String tagNameWithValue = part.substring(lastIndexOf);
                    if(XML_SENSITIVE_FIELD_NAMES.stream().anyMatch(tagNameWithValue::contains)){
                        String value = tagNameWithValue.split(">", 2)[1];
                        if(XML_SENSITIVE_FIELD_PATTERNS.stream().anyMatch(pattern -> pattern.matcher(tagNameWithValue).matches())){
                            payload = payload.replace(tagNameWithValue, tagNameWithValueReplaceXml(tagNameWithValue, value, MASKED_STRING));
                        }
                    }
                }

            }
        }
        return payload;
    }

    static String tagNameWithValueReplaceXml(String tagNameWithValue, String value, String masked) {
        // TODO:  exception Replace
        for (String replacementKey: EXCEPTION_REPLACES) {
            if (tagNameWithValue.contains(replacementKey)) {
                String displayPanOrToken = displayPanOrToken(value);
                if (displayPanOrToken.contains("_"))
                    return tagNameWithValue.replace(value, displayPanOrToken.replace("_", masked));
            }
        }
        return tagNameWithValue.replace(value, masked);
    }

    /**
     * Replace substring in {@literal source} that matches {@literal searchPattern}
     *
     * @param source        The source string
     * @param searchPattern The search pattern
     * @param replacement   The replacement string
     * @return The string constructed by replacing matching substring
     */
    public static String replace(String source, Pattern searchPattern, String replacement) {
        Matcher matcher = searchPattern.matcher(source);
        if (matcher.find()) {
            // TODO:  exception Replace
            for (String replacementKey: EXCEPTION_REPLACES) {
                if (replacement.contains("\"" + replacementKey + "\""))
                    return exceptionReplaceJson(matcher, replacementKey, replacement);
            }

            return matcher.replaceAll(replacement);
        }
        return source;
    }

    static String exceptionReplaceJson(Matcher matcher, String replacementKey, String replacement) {
        final String doubleQuotes = "\"";
        String group = matcher.group(1);
        if (StringUtils.isNotBlank(group)) {
            String replacementVal = doubleQuotes + replacementKey + doubleQuotes + ":";
            group = group.replace(replacementVal, "").replace(doubleQuotes, "");
            String displayPanOrToken = displayPanOrToken(group).replace("_", MASKED_STRING);
            replacement = replacementVal + doubleQuotes + displayPanOrToken + doubleQuotes;
        }
        return matcher.replaceAll(replacement);
    }

    public static String getElementsByTagName(String xmlText, String tagName) {
        try {
            Node node = xmlConvert(xmlText).getElementsByTagName(tagName).item(0);
            return node!= null ? node.getTextContent() : null;
        } catch (IOException|SAXException|ParserConfigurationException ex) {
            return null;
        }
    }

    public static String getAsString(String jsonText, String memberName) {
        try {
            JsonObject jsonObject = jsonConvert(jsonText);
            Set<Map.Entry<String, JsonElement>> entries = jsonObject.entrySet();

            JsonElement jsonElement = jsonObject.get(memberName);
            if (jsonElement!=null) {
                return jsonElement.getAsString();
            } else {
                for (Map.Entry<String, JsonElement> entry : entries) {
                    try {
                        JsonElement entryJsonElement = entry.getValue().getAsJsonObject().get(memberName);
                        if (entryJsonElement != null) return entryJsonElement.getAsString();
                    } catch (IllegalStateException ex) { }
                }
            }
        } catch (JsonSyntaxException|MalformedJsonException ex) {}
        return null;
    }

    private static Document xmlConvert(String text) throws IOException, SAXException, ParserConfigurationException {
        return DocumentBuilderFactory.newInstance()
                .newDocumentBuilder()
                .parse(new InputSource(new StringReader(text)));
    }

    private static JsonObject jsonConvert(String text) throws JsonSyntaxException, MalformedJsonException {
        return new JsonParser().parse(text)
                .getAsJsonObject();
    }

    /**
     * Get substring of input limited to <code>limit<bytes> bytes. Works like but limit is specified in bytes, not characters
     * I could just convert input to bytes, but I can brake last nont ascii-character in sequence.
     *
     * @param field      - Input data as Raw String
     * @param firstBytes Size of first part in result: <b>first_bytes</b>...last_bytes
     * @param lastBytes  Size of 2nd part in result: first_bytes...<b>last_bytes</b>
     * @return - new string with format ['first 200 bytes' ... 'last 50 symbols']
     */
    public static String substringLimitInBytes(String field, int firstBytes, int lastBytes) {

        if (StringUtils.isEmpty(field)) {
            return field;
        }

        assert firstBytes >= 0;
        assert lastBytes >= 0;
        assert firstBytes > 0 || lastBytes > 0;

        byte[] fieldAsBytes = field.getBytes(UTF_8);

        if (fieldAsBytes.length <= firstBytes + lastBytes) {
            return field;
        }

        StringBuilder result = new StringBuilder();

        if (firstBytes > 0) {
            byte[] portionBytes = new byte[firstBytes + 1];
            System.arraycopy(fieldAsBytes, 0, portionBytes, 0, portionBytes.length);
            StringBuilder portionString = new StringBuilder(new String(portionBytes, UTF_8));
            result.append(portionString.substring(0, portionString.length() - 1));
        }

        result.append("...");

        if (lastBytes > 0) {
            byte[] portionBytes = new byte[lastBytes + 1];
            System.arraycopy(fieldAsBytes, fieldAsBytes.length - portionBytes.length, portionBytes, 0, portionBytes.length);
            StringBuilder portionString = new StringBuilder(new String(portionBytes, UTF_8));
            result.append(portionString.substring(1));
        }

        return result.toString();
    }

    // Converts String "/aSimplePath" into "A_SIMPLE_PATH" with replacing odd symbols
    public static String toUppercaseWordsWithUnderscores(String name) {
        if (StringUtils.isEmpty(name)) {
            return null;
        }
        return Stream.of(name.split("(?<!(^|[A-Z]))(?=[A-Z])|(?<!^)(?=[A-Z][a-z])"))
                .map(w -> w.toUpperCase().replaceAll("[\\W]", ""))
                .collect(Collectors.joining("_"));
    }

    /**
     * Hide number in phone
     *
     * @param number
     * @return masked phone number if correct otherwise {@number}
     */
    public static String maskPhoneNumber(String number) {
        Pattern pattern = Pattern.compile("(\\W38)?([0-9]{10})");
        if(StringUtils.isNotBlank(number) && pattern.matcher(number).find()){
            String prefix ="+38";
            boolean containsPrefix = number.contains(prefix);
            number = containsPrefix ? number.substring(3, 13) : number;
            StringBuilder numberBuild = new StringBuilder(number);
            numberBuild.replace(2, 8, "XXXXXX");
            numberBuild.insert(3, "-");
            numberBuild.insert(7, "-");
            return containsPrefix ? prefix + numberBuild.toString() : numberBuild.toString();
        }
        return number;
    }

    /**
     * Generates the check digit required to make the given credit card number
     * valid (i.e. pass the Luhn check)<br>
     * https://gist.github.com/josefeg/5781824
     *
     * @param sequence The number for which to generate the check digit.
     * @return The check digit required to make the given credit card number
     * valid.
     */
    public static int generateSymbolWithLuhnAlgorithm(String sequence){
        // Get the sum of all the digits, however we need to replace the value
        // of the first digit, and every other digit, with the same digit
        // multiplied by 2. If this multiplication yields a number greater
        // than 9, then add the two digits together to get a single digit
        // number.
        //
        // The digits we need to replace will be those in an even position for
        // card numbers whose length is an even number, or those is an odd
        // position for card numbers whose length is an odd number. This is
        // because the Luhn algorithm reverses the card number, and doubles
        // every other number starting from the second number from the last
        // position.
        int sum = 0;
        for (int i = 0; i < sequence.length() - 1; i++) {

            // Get the digit at the current position.
            int digit = Integer.parseInt(sequence.substring(i, (i + 1)));

            if ((i % 2) == 0) {
                digit = digit * 2;
                if (digit > 9) {
                    digit = (digit / 10) + (digit % 10);
                }
            }
            sum += digit;
        }

        // The check digit is the number required to make the sum a multiple of
        // 10.
        int mod = sum % 10;
        return ((mod == 0) ? 0 : 10 - mod);
    }

    /**
     * Generate masked pan or maskedToken with checking string length and null. When input value is not valid then return original value<p>
     * Example: PAN 1234567898765 -> PAN display 123456_8765 <p>
     *
     * @param pan card number (PAN)
     * @return masked card number
     */
    public static String displayPanOrToken(String pan) {
        Pattern pattern = Pattern.compile("([0-9]{13,19})");
        if(StringUtils.isNotBlank(pan) && pattern.matcher(pan).find()){
            return pan.substring(0,FIRST_PAN_SYMBOLS_TO_DISPLAY)+"_"+pan.substring(pan.length()-LAST_PAN_SYMBOLS_TO_DISPLAY);
        }
        return pan;
    }

}
