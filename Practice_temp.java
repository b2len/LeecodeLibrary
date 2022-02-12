
while (left <= right) {
    mid = (left + right) / 2;
    if (a[mid] = target) {
        return mid;
    } else if (a[mid] < target) {
        left = mid + 1;
    } else {
        right = mid - 1;        
    }
}

public class IsUnique {
    public static boolean isUnique(String string) {
        Array stringArray = string.toarray;
        for (int i = 0; i <= stringArray.length; i++) {
            for (int j = i + 1; j <= stringArray; j++) {
                if (stringArray[i] == stringArray[j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args){
        String test = "akcidlnsdiaknfgjid";
        result = isUnique(test);
        System.out.printline("expect flase and the outcome is " + result);
    }
}