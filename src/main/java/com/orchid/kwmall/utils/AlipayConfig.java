package com.orchid.kwmall.utils;

import java.io.FileWriter;
import java.io.IOException;

public class AlipayConfig {

    public static String app_id = "2016102600763215";

    public static String merchant_private_key = "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQC/UvPo1MJA4iZ8FeXSxKM7M/1TaXG5yJBkEwDO/ec18Y+4bOHwqBFhiwUuFsKc6/T9HafPYwwHhyUiZUMMdt0LKZ6a0ipqfgBiQpU3EYpcUWV8nuN2wQ3TKkOnPIOCII9wkO69MUiavlhnUbxJZBb1s9yBljO1G+G5wa6dGUE4IpTNPQws1yx+ZalXrpWFeHSGl7Im1XN4wZqf5iU/JW8iGTKxfXrtTReM9AJhbb0+KWm+2tE0cqxLHmAjjq13zwvwcguguLuK3t61eJtVAu1d3JY+ufg0WeBsl4f2ADbxSoAMKR9Msr6mZ+HbvKXw1dHQLHhjo/dJvOnv+gK0k2t9AgMBAAECggEAXBTam3a6v2uYxiPr5tMJFNdi1yBqwdXL2L5kpzsAarAGUebln2PkaaP1LEd8BvZxhNkfCOtMwNrEfpdp+7fBjzvKwAziqTpXiPMuycBBbUknpSD7rQ4hTz6KLRUs3hY5sx2uKZRssz1lYuSt0EzB2CNmv1/BJytyKmsTVTzwbMky21XYhZT8g3IFvbK1/TGWlx5TbLJowMBFB0uh3WbUOPPDiDkoe+z8veX4CbbxnuoP+YxJtIImzJRvv5oQB4h4FZPcSkT2yBE7Bzq23m1ZU1nfHFQtqp2AAvLGt+MTPxfXiiopiRGtg0XW917Ged/tP9PJwYeyV+UZyXH2F20dKQKBgQDkshv/xb5Vv/6/nEAgqLOX4BDHvku9AsuELF0WOENYNEHBSPpyKbkXSs1TW+cHXOZsZmqRNrIQv2gR9etHieYRi9w+qlmRxInORA6hzCNfFX7JaLZ1FQLUuni+MzLM2qEJuOxIFyS3sw3j/U6XQU9tx8LSYs69IMED7u7aWyVOgwKBgQDWKpvpfdvWRP8AEfIzWXgZ21sVfzMZ/Oy9WwkS2W1ROJuXKiyTO69174Guv4pqtYzz/7G4kx+Wq4zHymEPRKr1HfVxTCIWsYGQetjXOft+XovY9bzJugIlQg/n4fyC7DB6QNlOdUXm9xcYqJsJ06/z3pb9HIea8MakjQh/0Gc9/wKBgQCY8p1TI7a1tp/zGdaxgOILcqkGTThuAk6F6P2gfKRdeyV21Q3aCBlngHlthIswG2tnl98xmvjfxoMdb/CYeZtKpNT5fAhHOsBHGLEIeHQ3hTK0FLnh99la2BMkcS1KX/VPgUNUu1WtHazui1xiQCWU8AJVngtR5XPw430Ov+JlbQKBgQC1gQr9yZKkd3j9oDf52Nt2XndFMrYmUjp5CEwaU3bYHPeQF0gLx8ueUctAREiUwySgLZV67gUZdm4rbJLxk6qnbipzSKijPvCld9eKIDPKF2rCBxFmjWQAG4rLZLTSaEV1drw0SCNj6QkD9vDeVS+LqJuiC6nJYEGZd4U6fW7iFQKBgQDUoWwBe+1g3buFyf0ji/azDFGbH4WzZPOl+zw1AZ1s9Ng/N/OUWK0ZSfnKHaJGqHWS5QXeJ2m7xR5TMcHb3WBatmx4e4MIoWoWdncXxjjDtmrpcHCY6UUMeAusHLJkq9Tpdhu4ZzYiM3bkU+HE5+OAZD9HCCPzockIg/UXgRK7FA==";

    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEApCq6jWlLyUMWhTAAWKdRTGEB48v818OKTvEaX9ltup8M4gljoZ2ese39S9JQybCByuM53Ov4bFzQse1a9pPBWbl0ikGWFF3wb2VoJ/wsHlWLLhi1/AWTZsCx8QoKGywugtuCwc5qk4HK3EreYga/G+X44Gdru7Z2NAneOdsx93q0+3tbqWn6MAWB0NlI/j4ovinHiT9fPirmlsrp00w/Tit2VMWoq84vavH+QxPbPzsYmESc4Nt9rKLTFkquyRyxsqGa/ZT4EsvtDFyTgqhsO47qVIHztQlEdAMfZ/yka/X9H7Fjgd+ePxKVGW02lRZFoIy8euvJCYNv0XDr6PKMDQIDAQAB";

    public static String notify_url = "http://localhost:8080/static/notify_url.jsp";

    public static String return_url = "http://localhost:8080/kwmall/payment/back";

    public static String sign_type = "RSA2";

    public static String charset = "utf-8";

    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    public static String log_path = "D:/java/idea/kw-mall/";


    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}