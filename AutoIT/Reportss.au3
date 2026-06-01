; Wait for "Confirm Save As" window to appear for up to 2 seconds
If WinWaitActive("Confirm Save As", "", 2) Then
    ; Click the "Yes" button to overwrite the file
    ControlClick("Confirm Save As", "", "Button1")
EndIf