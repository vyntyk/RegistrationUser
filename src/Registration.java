import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Registration {

    public static void main(String[] args) {
        // Step 1: Greeting window
        int response = JOptionPane.showConfirmDialog(null,
                "Добро пожаловать! Хотите зарегистрироваться в программе?",
                "Регистрация",
                JOptionPane.YES_NO_OPTION);

        if (response == JOptionPane.NO_OPTION) {
            System.exit(0);
        }

        // Step 2: Username input window
        String username = "";
        boolean validUsername = false;
        while (!validUsername) {
            username = JOptionPane.showInputDialog(null,
                    "Пожалуйста, введите логин (более 5 символов, без пробелов):",
                    "Регистрация",
                    JOptionPane.QUESTION_MESSAGE);

            if (username != null && username.length() > 5 && !username.contains(" ")) {
                validUsername = true;
            } else {
                JOptionPane.showMessageDialog(null,
                        "Логин должен быть больше 5 символов и не содержать пробелов.",
                        "Ошибка",
                        JOptionPane.ERROR_MESSAGE);
            }
        }

        // Step 3: Password input window
        JPasswordField passwordField = new JPasswordField();
        boolean validPassword = false;
        String password = "";
        while (!validPassword) {
            int passwordOption = JOptionPane.showConfirmDialog(null,
                    passwordField,
                    "Пожалуйста, введите пароль (более 8 символов, без пробелов, минимум одна цифра и одна буква):",
                    JOptionPane.OK_CANCEL_OPTION);

            if (passwordOption == JOptionPane.OK_OPTION) {
                password = new String(passwordField.getPassword());
                if (password.length() > 8 && password.matches(".*\\d.*") && password.matches(".*[a-zA-Z].*") && !password.contains(" ")) {
                    validPassword = true;
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Пароль должен быть больше 8 символов, не содержать пробелов и содержать минимум одну цифру и одну букву.",
                            "Ошибка",
                            JOptionPane.ERROR_MESSAGE);
                }
            } else {
                System.exit(0);
            }
        }

        // Step 4: Password confirmation window
        JPasswordField confirmPasswordField = new JPasswordField();
        boolean passwordsMatch = false;
        while (!passwordsMatch) {
            int confirmPasswordOption = JOptionPane.showConfirmDialog(null,
                    confirmPasswordField,
                    "Пожалуйста, повторите пароль:",
                    JOptionPane.OK_CANCEL_OPTION);

            if (confirmPasswordOption == JOptionPane.OK_OPTION) {
                String confirmPassword = new String(confirmPasswordField.getPassword());
                if (confirmPassword.equals(password)) {
                    passwordsMatch = true;
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Пароли не совпадают. Пожалуйста, попробуйте снова.",
                            "Ошибка",
                            JOptionPane.ERROR_MESSAGE);
                }
            } else {
                System.exit(0);
            }
        }

        // Step 5: Successful registration window
        JOptionPane.showMessageDialog(null,
                "Регистрация успешна!",
                "Успех",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
