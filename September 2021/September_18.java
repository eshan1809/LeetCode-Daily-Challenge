class Solution {
    public List<String> addOperators(String num, int target) {
        list = new ArrayList<>();
        if(target == Integer.MIN_VALUE)
            return list;
        helper(num, target, 1, num.charAt(0) + "");
        return list;
    }
    
    List<String> list;
    
    public void helper(String num, int target, int idx, String asf){
        if(idx == num.length()){
            if(eval(asf) == target)
                list.add(asf);
            return;
        }
        helper(num, target, idx + 1, asf + '*' + num.charAt(idx));
        helper(num, target, idx + 1, asf + '+' + num.charAt(idx));
        helper(num, target, idx + 1, asf + '-' + num.charAt(idx));
        int i = asf.length() - 1;
        while(i >= 0 && asf.charAt(i) == '0')
            i--;
        if(i >= 0 && Character.isDigit(asf.charAt(i)))
            helper(num, target, idx + 1, asf + num.charAt(idx));
    }
    
    public int eval(String str){
        Stack<Integer> opd = new Stack<>();
        Stack<Character> opr = new Stack<>();
        boolean prev = false;
        for(char ch : str.toCharArray()){
            if(ch == '+' || ch == '-' || ch == '*'){
                while(!opr.isEmpty() && pre(ch) <= pre(opr.peek())){
                    char op = opr.pop();
                    int v2 = opd.pop(), v1 = opd.pop();
                    if(op == '-')
                        opd.push(v1 - v2);
                    else if(op == '+')
                        opd.push(v1 + v2);
                    else
                        opd.push(v1 * v2);
                }
                opr.push(ch);
                prev = false;
            } else{
                if(prev)
                    opd.push(opd.pop() * 10 + (ch - '0'));
                else
                    opd.push(ch - '0');
                prev = true;
            }
        }
        while(!opr.isEmpty()){
            char op = opr.pop();
            int v2 = opd.pop(), v1 = opd.pop();
            if(op == '-')
                opd.push(v1 - v2);
            else if(op == '+')
                opd.push(v1 + v2);
            else
                opd.push(v1 * v2);
        }
        return opd.pop();
    }
    
    public int pre(char op){
        if(op=='+' || op=='-')
            return 1;
        return 2;
    }
}
