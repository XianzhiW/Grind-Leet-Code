
#include <iostream>
#include <stack>

using namespace std;
bool isValid(string s) {
    stack<char> st;

    for(char c:s) {
        if(c=='(' || c=='{' || c=='[') {
            st.push(c);
        }
        else {
            if(st.empty()) {
                return false;
            }
            if(c==')' and st.top() =='(' ){
                st.pop();
            }
            else if(c=='}' and st.top() =='{' ){
                st.pop();
            }
            else if(c==']' and st.top() =='[' ){
                st.pop();
            }
            else {
                return false;
            }

        }
    }
    if(st.empty()) {
        return true;
    }

    return false;


}

int main() {
    string expression = "()[(){()}]";
    if (isValid(expression))
        cout << "this is balanced expression\n\n";
    else
        cout << "this is not balanced expression\n\n";
}







