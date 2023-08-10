import { useState, useRef } from 'react';
import AceEditor from 'react-ace';
import './styles/StudyArea.css';
import 'ace-builds/src-noconflict/theme-dracula';
import 'ace-builds/src-noconflict/mode-javascript';
import CodeOutput from '../components/codeOutput';

function StudyArea() {
    const [code, setCode] = useState('const message = "Hello World!" \n\nconsole.log(message);');
    const embedId = "qAgzr8Fo6LM";

    return (
        <div className="StudyArea">
            <div className='lesson'>
                <iframe
                    width="99%"
                    height="500rem"
                    src={`https://www.youtube.com/embed/${embedId}`}
                    allow="picture-in-picture"
                    allowFullScreen
                    title="Embedded youtube"
                />
            </div>
            <div>
                Tarefas
                <ul>
                    <li>Tarefa 1</li>
                    <li>Tarefa 2</li>
                    <li>Tarefa 3</li>
                    <li>Tarefa 4</li>
                </ul>
            </div>
            <AceEditor
                mode="javascript"
                theme="dracula"
                value={code}
                onChange={(value) => setCode(value)}
                name="editor"
                style={{ width: '100%', height: '500px' }}
                fontSize={"16px"}
                editorProps={{ $blockScrolling: true }}
            />
            <CodeOutput />
        </div>
    )
}

export default StudyArea;

