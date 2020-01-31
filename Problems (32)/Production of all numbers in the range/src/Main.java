(l, r) -> {
    long sum = l;
    for(long i = l + 1; i <= r; i++) {
        sum *= i;
    }
    return sum;
};