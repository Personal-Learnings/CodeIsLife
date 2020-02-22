package com.learnings.practise.designpatterns;

import java.util.HashSet;
import java.util.Set;

import static com.learnings.practise.designpatterns.HTTPCode.SITE_BLOCKED;

public class Proxy {
    public static void main(String[] args) {
        Network network = new ProxyInternet();
        System.out.println(network.connect("http://www.google.com"));
        System.out.println(network.connect("http://www.sample.com"));
    }
}

class ProxyInternet implements Network {

    private Set<String> blockedSides;
    private Internet internet;

    ProxyInternet() {
        blockedSides = new HashSet<>();
        internet = new Internet();

        blockedSides.add("http://www.sample.com");
        blockedSides.add("http://www.sample2.com");
    }

    @Override
    public HTTPCode connect(String url) {
        return blockedSides.contains(url) ? SITE_BLOCKED : internet.connect(url);
    }
}

class Internet implements Network {
    @Override
    public HTTPCode connect(String url) {
        return HTTPCode.SUCCESS_200;
    }
}

interface Network {
    HTTPCode connect(String url);
}

enum HTTPCode {
    HTTP_404, HTTP_500, SITE_BLOCKED, SUCCESS_200
}